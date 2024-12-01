import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainerAllotment {

    private Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/GYM";
        String user = "root";  
        String password = "123456";  
        return DriverManager.getConnection(url, user, password);
    }
private void deleteOldSessions(int memberId) {
    String sql = "DELETE FROM Sessions WHERE MemberID = ?";
    
    try (Connection conn = connect(); 
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
         
        pstmt.setInt(1, memberId);
        
        int affectedRows = pstmt.executeUpdate();
        
        if (affectedRows > 0) {
            System.out.println("Deleted old sessions for member ID: " + memberId);
        } else {
            System.out.println("No old sessions found for member ID: " + memberId);
        }
        
    } catch (SQLException e) {
        System.out.println("Error deleting old sessions: " + e.getMessage());
    }
} 

    public List<Member> getAllMembers() {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM members"; 
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Member member = new Member();
                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));
                member.setTiming(rs.getString("timing")); 
                member.setGoal(rs.getString("goal"));     
                members.add(member);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving members: " + e.getMessage());
        }
        return members;
    }

    public List<Trainer> getAllTrainers() {
        List<Trainer> trainers = new ArrayList<>();
        String sql = "SELECT * FROM trainers"; 
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Trainer trainer = new Trainer();
                trainer.setId(rs.getInt("id"));
                trainer.setName(rs.getString("name"));
                trainer.setShiftHours(rs.getString("shift_timing"));
                trainer.setSpecialization(rs.getString("specialization"));
                trainers.add(trainer);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving trainers: " + e.getMessage());
        }
        return trainers;
    }

public Trainer assignTrainer(Member member, List<Trainer> trainers) {
    for (Trainer trainer : trainers) {
        if (trainer.getShiftHours().equals(member.getTiming()) &&
            trainer.getSpecialization().equals(member.getGoal())) {
            return trainer; 
        }
    }
    return null; 
}

public void allocateTrainerToMembers() {
    List<Member> members = getAllMembers();
    List<Trainer> trainers = getAllTrainers();
    
    for (Member member : members) {
        Trainer currentTrainer = getCurrentTrainer(member.getId());
        
        if (currentTrainer == null) {
            System.out.println("No current trainer for member " + member.getName() + ". Assigning a new trainer.");
            Trainer newTrainer = assignTrainer(member, trainers);
            if (newTrainer != null) {
                saveSession(member.getId(), newTrainer.getId(), new Timestamp(System.currentTimeMillis()));
                System.out.println("Trainer " + newTrainer.getName() + " assigned to member " + member.getName());
            } else {
                System.out.println("No available trainer found for member " + member.getName());
            }
        } else {
            if (!member.getTiming().equals(currentTrainer.getShiftHours()) || 
                !member.getGoal().equals(currentTrainer.getSpecialization())) {

                System.out.println("Timing or goal changed for member " + member.getName() + ". Checking for a suitable trainer.");
                Trainer newTrainer = assignTrainer(member, trainers);
                if (newTrainer != null) {
                    deleteOldSessions(member.getId());
                    
                    saveSession(member.getId(), newTrainer.getId(), new Timestamp(System.currentTimeMillis()));
                    System.out.println("Trainer " + newTrainer.getName() + " reassigned to member " + member.getName());
                } else {
                    System.out.println("No available trainer found for member " + member.getName());
                }
            } else {
                System.out.println("Member " + member.getName() + " retains trainer " + currentTrainer.getName());
            }
        }
    }
}

private Trainer getCurrentTrainer(int memberId) {
    List<Session> sessions = getSessionsForMember(memberId);
    if (!sessions.isEmpty()) {
        int trainerId = sessions.get(sessions.size() - 1).getTrainerID(); 
        return getTrainerById(trainerId);
    }
    return null; 
}

private Trainer getTrainerById(int trainerId) {
    Trainer trainer = null;
    String sql = "SELECT * FROM trainers WHERE id = ?";
    
    try (Connection conn = connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
        pstmt.setInt(1, trainerId);
        ResultSet rs = pstmt.executeQuery();
    
        if (rs.next()) {
            trainer = new Trainer();
            trainer.setId(rs.getInt("id"));
            trainer.setName(rs.getString("name"));
            trainer.setShiftHours(rs.getString("shift_timing"));
            trainer.setSpecialization(rs.getString("specialization"));
        }
    } catch (SQLException e) {
        System.out.println("Error retrieving trainer: " + e.getMessage());
    }
    return trainer;
}

private void updateSession(int memberId, int trainerId, Timestamp sessionDate) {
    saveSession(memberId, trainerId, sessionDate);
}

    private boolean hasAssignedTrainer(int memberId) {
        List<Session> sessions = getSessionsForMember(memberId);
        return !sessions.isEmpty(); 
    }

    private void saveSession(int memberId, int trainerId, Timestamp sessionDate) {
        String sql = "INSERT INTO Sessions (MemberID, TrainerID, SessionDate) VALUES (?, ?, ?)";
        
        try (Connection conn = connect(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, memberId);
            pstmt.setInt(2, trainerId);
            pstmt.setTimestamp(3, sessionDate);
            pstmt.executeUpdate();
            System.out.println("Session saved for Member ID: " + memberId + " with Trainer ID: " + trainerId);
        } catch (SQLException e) {
            System.out.println("Error saving session: " + e.getMessage());
        }
    }

    public List<Session> getSessionsForMember(int memberId) {
        List<Session> sessions = new ArrayList<>();
        String sql = "SELECT * FROM Sessions WHERE MemberID = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, memberId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Session session = new Session();
                session.setSessionID(rs.getInt("SessionID"));
                session.setMemberID(rs.getInt("MemberID"));
                session.setTrainerID(rs.getInt("TrainerID"));
                session.setSessionDate(rs.getTimestamp("SessionDate"));
                sessions.add(session);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving sessions: " + e.getMessage());
        }
        return sessions;
    }

    public static class Member {
        private int id;
        private String name;
        private String timing;  
        private String goal;    

        public Member(int id, String name, String timing, String goal) {
            this.id = id;
            this.name = name;
            this.timing = timing;
            this.goal = goal;
        }

        public Member() {}

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getTiming() {
            return timing;
        }

        public String getGoal() {
            return goal;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setTiming(String timing) {
            this.timing = timing;
        }

        public void setGoal(String goal) {
            this.goal = goal;
        }
    }
    public static class Trainer {
        private int id;
        private String name;
        private String shiftHours;
        private String specialization;

        public Trainer(int id, String name, String shiftHours, String specialization) {
            this.id = id;
            this.name = name;
            this.shiftHours = shiftHours;
            this.specialization = specialization;
        }

        public Trainer() {}

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getShiftHours() {
            return shiftHours;
        }

        public String getSpecialization() {
            return specialization;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setShiftHours(String shiftHours) {
            this.shiftHours = shiftHours;
        }

        public void setSpecialization(String specialization) {
            this.specialization = specialization;
        }
    }

    public static class Session {
        private int sessionID;
        private int memberID;
        private int trainerID;
        private Timestamp sessionDate;

        public Session(int sessionID, int memberID, int trainerID, Timestamp sessionDate) {
            this.sessionID = sessionID;
            this.memberID = memberID;
            this.trainerID = trainerID;
            this.sessionDate = sessionDate;
        }

        public Session() {}

        public int getSessionID() {
            return sessionID;
        }

        public int getMemberID() {
            return memberID;
        }

        public int getTrainerID() {
            return trainerID;
        }

        public Timestamp getSessionDate() {
            return sessionDate;
        }

        public void setSessionID(int sessionID) {
            this.sessionID = sessionID;
        }

        public void setMemberID(int memberID) {
            this.memberID = memberID;
        }

        public void setTrainerID(int trainerID) {
            this.trainerID = trainerID;
        }

        public void setSessionDate(Timestamp sessionDate) {
            this.sessionDate = sessionDate;
        }
    }
    public void allocateTrainerToNewMember(int memberId) {
        Member member = getMemberById(memberId); 
    
        List<Trainer> trainers = getAllTrainers();
    
        Trainer trainer = assignTrainer(member, trainers);
        
        if (trainer != null) {
            saveSession(member.getId(), trainer.getId(), new Timestamp(System.currentTimeMillis()));
            System.out.println("Trainer " + trainer.getName() + " assigned to new member " + member.getName());
        } else {
            System.out.println("No available trainer found for new member " + member.getName());
        }
    }
    
    private Member getMemberById(int memberId) {
        Member member = null;
        String sql = "SELECT * FROM members WHERE id = ?";
    
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setInt(1, memberId);
            ResultSet rs = pstmt.executeQuery();
    
            if (rs.next()) {
                member = new Member();
                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));
                member.setTiming(rs.getString("timing"));
                member.setGoal(rs.getString("goal"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving member: " + e.getMessage());
        }
        return member;
    }
    public static void main(String[] args) {
        TrainerAllotment allotment = new TrainerAllotment();
        
        allotment.allocateTrainerToMembers();
        
        int memberIdToCheck = 1;
        List<Session> sessions = allotment.getSessionsForMember(memberIdToCheck);
        for (Session session : sessions) {
            System.out.println("Session ID: " + session.getSessionID() + ", Trainer ID: " + session.getTrainerID() + ", Date: " + session.getSessionDate());
        }
    }
    
}  