USE GYM;
CREATE TABLE workout_plans (
    id INT AUTO_INCREMENT PRIMARY KEY,
    age_range VARCHAR(20),
    goal VARCHAR(30),
    days_per_week INT,
    intensity VARCHAR(15),
    day1_exercises TEXT,
    day2_exercises TEXT,
    day3_exercises TEXT,
    day4_exercises TEXT,
    day5_exercises TEXT,
    day6_exercises TEXT
);
drop table workout_plans;
SELECT * FROM workout_plans;
 --   1st data 
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises
) 
VALUES (
    '46-60', 'General Workout', 4, 'Intermediate', 
    'Full Body Strength\nGoblet Squat\nSets: 3\nReps: 10-12\nDumbbell Bench Press\nSets: 3\nReps: 8-10\nLat Pulldown\nSets: 3\nReps: 10-12\nDumbbell Deadlift\nSets: 3\nReps: 8-10\nPlank\nSets: 3\nDuration: 30-45 sec', 
    'Lower Body & Core\nLeg Press (Machine)\nSets: 4\nReps: 8-10\nWalking Lunges (Dumbbell)\nSets: 3\nReps: 10-12 per leg\nRomanian Deadlift\nSets: 3\nReps: 8-10\nGlute Bridge\nSets: 3\nReps: 10-12\nRussian Twists\nSets: 3\nReps: 12-15 per side', 
    'Upper Body\nPush-Ups (Modified if needed)\nSets: 3\nReps: 10-12\nSeated Dumbbell Shoulder Press\nSets: 3\nReps: 8-10\nBent Over Rows (Dumbbell)\nSets: 3\nReps: 10-12\nTricep Dips (Bench)\nSets: 3\nReps: 8-10\nBicep Curls (Dumbbell)\nSets: 3\nReps: 10-12', 
    'Mobility & Endurance\nBodyweight Squats\nSets: 3\nReps: 12-15\nStationary Bike or Fast Walking\nDuration: 20-30 min (moderate intensity)\nKettlebell Swings\nSets: 3\nReps: 12-15\nLateral Lunges (Bodyweight)\nSets: 3\nReps: 10-12 per side\nStanding Calf Raises\nSets: 3\nReps: 12-15'
);


--   2nd data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises
) 
VALUES (
    '46-60', 'General Workout', 5, 'Intermediate', 
    'Upper Body\nDumbbell Bench Press\nSets: 3\nReps: 8-10\nLat Pulldown\nSets: 3\nReps: 10-12\nSeated Dumbbell Shoulder Press\nSets: 3\nReps: 8-10\nDumbbell Bent Over Rows\nSets: 3\nReps: 10-12\nTricep Dips (Bench)\nSets: 3\nReps: 8-10', 
    'Lower Body\nBarbell Squats\nSets: 4\nReps: 8-10\nWalking Lunges (Dumbbell)\nSets: 3\nReps: 10-12 per leg\nLeg Press (Machine)\nSets: 3\nReps: 10-12\nCalf Raises (Standing)\nSets: 4\nReps: 12-15\nGlute Bridge\nSets: 3\nReps: 10-12', 
    'Full Body Strength\nGoblet Squat\nSets: 3\nReps: 10-12\nDeadlifts (Dumbbell or Barbell)\nSets: 3\nReps: 8-10\nPush-Ups (Modified if needed)\nSets: 3\nReps: 10-12\nPlank\nSets: 3\nDuration: 30-45 sec\nDumbbell Side Raises\nSets: 3\nReps: 10-12', 
    'Core & Mobility\nRussian Twists\nSets: 3\nReps: 12-15 per side\nHanging Knee Raises\nSets: 3\nReps: 10-12\nSide Plank\nSets: 3\nDuration: 20-30 sec per side\nBird-Dogs\nSets: 3\nReps: 10-12 per side\nFoam Rolling & Stretching\nDuration: 10-15 min', 
    'Cardio & Endurance\nWalking or Jogging on Treadmill\nDuration: 20-30 min (moderate intensity)\nKettlebell Swings\nSets: 3\nReps: 12-15\nBattle Ropes (if available)\nSets: 3\nDuration: 30-45 sec\nStationary Bike or Elliptical\nDuration: 20 min (steady pace)\nStanding Calf Raises\nSets: 3\nReps: 12-15'
);


--  3rd data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises, day6_exercises
) 
VALUES (
    '46-60', 'General Workout', 6, 'Intermediate', 
    'Upper Body\nDumbbell Bench Press\nSets: 3\nReps: 8-10\nLat Pulldown\nSets: 3\nReps: 10-12\nSeated Dumbbell Shoulder Press\nSets: 3\nReps: 8-10\nDumbbell Bent Over Rows\nSets: 3\nReps: 10-12\nTricep Dips (Bench)\nSets: 3\nReps: 8-10', 
    'Lower Body\nBarbell Squats\nSets: 4\nReps: 8-10\nWalking Lunges (Dumbbell)\nSets: 3\nReps: 10-12 per leg\nLeg Press (Machine)\nSets: 3\nReps: 10-12\nCalf Raises (Standing)\nSets: 4\nReps: 12-15\nGlute Bridge\nSets: 3\nReps: 10-12', 
    'Full Body Strength\nGoblet Squat\nSets: 3\nReps: 10-12\nDeadlifts (Dumbbell or Barbell)\nSets: 3\nReps: 8-10\nPush-Ups (Modified if needed)\nSets: 3\nReps: 10-12\nPlank\nSets: 3\nDuration: 30-45 sec\nDumbbell Side Raises\nSets: 3\nReps: 10-12', 
    'Core & Mobility\nRussian Twists\nSets: 3\nReps: 12-15 per side\nHanging Knee Raises\nSets: 3\nReps: 10-12\nSide Plank\nSets: 3\nDuration: 20-30 sec per side\nBird-Dogs\nSets: 3\nReps: 10-12 per side\nFoam Rolling & Stretching\nDuration: 10-15 min', 
    'Cardio & Endurance\nWalking or Jogging on Treadmill\nDuration: 20-30 min (moderate intensity)\nKettlebell Swings\nSets: 3\nReps: 12-15\nBattle Ropes (if available)\nSets: 3\nDuration: 30-45 sec\nStationary Bike or Elliptical\nDuration: 20 min (steady pace)\nStanding Calf Raises\nSets: 3\nReps: 12-15', 
    'Active Recovery\nLight Yoga or Stretching\nDuration: 30-40 min\nWalking\nDuration: 20-30 min (easy pace)\nGentle Swimming\nDuration: 20-30 min (if accessible)'
);


--  4th data 
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises
) 
VALUES (
    '46-60', 'Muscle Gain', 4, 'Intermediate', 
    'Upper Body (Push)\nBarbell Bench Press\nSets: 4\nReps: 6-8\nIncline Dumbbell Press\nSets: 3\nReps: 8-10\nDumbbell Shoulder Press\nSets: 3\nReps: 8-10\nLateral Raises\nSets: 3\nReps: 10-12\nTricep Dips (Weighted if possible)\nSets: 3\nReps: 6-8\nOverhead Tricep Extension (Dumbbell or EZ Bar)\nSets: 3\nReps: 10-12', 
    'Lower Body\nBarbell Squats\nSets: 4\nReps: 6-8\nRomanian Deadlifts\nSets: 3\nReps: 8-10\nLeg Press (Machine)\nSets: 3\nReps: 8-10\nWalking Lunges (Dumbbell)\nSets: 3\nReps: 10-12 per leg\nCalf Raises (Seated or Standing)\nSets: 4\nReps: 10-12\nLeg Curls (Machine)\nSets: 3\nReps: 10-12', 
    'Upper Body (Pull)\nPull-Ups (Assisted if necessary)\nSets: 4\nReps: 6-8\nBent Over Barbell Rows\nSets: 4\nReps: 8-10\nSeated Cable Rows\nSets: 3\nReps: 10-12\nFace Pulls\nSets: 3\nReps: 10-12\nBarbell Bicep Curls\nSets: 3\nReps: 8-10\nHammer Curls\nSets: 3\nReps: 10-12', 
    'Legs & Core\nDeadlifts (Conventional or Sumo)\nSets: 4\nReps: 6-8\nBulgarian Split Squats\nSets: 3\nReps: 10-12 per leg\nLeg Extensions (Machine)\nSets: 3\nReps: 10-12\nPlank\nSets: 3\nDuration: 30-60 sec\nHanging Leg Raises\nSets: 3\nReps: 10-12\nSeated Calf Raises\nSets: 3\nReps: 10-12'
);


--  5th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises
) 
VALUES (
    '46-60', 'Muscle Gain', 5, 'Intermediate', 
    'Upper Body (Push)\nBarbell Bench Press\nSets: 4\nReps: 6-8\nIncline Dumbbell Press\nSets: 3\nReps: 8-10\nDumbbell Shoulder Press\nSets: 3\nReps: 8-10\nLateral Raises\nSets: 3\nReps: 10-12\nTricep Dips (Weighted if possible)\nSets: 3\nReps: 6-8\nOverhead Tricep Extension (Dumbbell or EZ Bar)\nSets: 3\nReps: 10-12', 
    'Lower Body\nBarbell Squats\nSets: 4\nReps: 6-8\nRomanian Deadlifts\nSets: 3\nReps: 8-10\nLeg Press (Machine)\nSets: 3\nReps: 8-10\nWalking Lunges (Dumbbell)\nSets: 3\nReps: 10-12 per leg\nCalf Raises (Seated or Standing)\nSets: 4\nReps: 10-12\nLeg Curls (Machine)\nSets: 3\nReps: 10-12', 
    'Upper Body (Pull)\nPull-Ups (Assisted if necessary)\nSets: 4\nReps: 6-8\nBent Over Barbell Rows\nSets: 4\nReps: 8-10\nSeated Cable Rows\nSets: 3\nReps: 10-12\nFace Pulls\nSets: 3\nReps: 10-12\nBarbell Bicep Curls\nSets: 3\nReps: 8-10\nHammer Curls\nSets: 3\nReps: 10-12', 
    'Legs & Core\nDeadlifts (Conventional or Sumo)\nSets: 4\nReps: 6-8\nBulgarian Split Squats\nSets: 3\nReps: 10-12 per leg\nLeg Extensions (Machine)\nSets: 3\nReps: 10-12\nPlank\nSets: 3\nDuration: 30-60 sec\nHanging Leg Raises\nSets: 3\nReps: 10-12\nSeated Calf Raises\nSets: 3\nReps: 10-12', 
    'Full Body\nClean and Press\nSets: 4\nReps: 6-8\nKettlebell Swings\nSets: 3\nReps: 10-12\nPush-Ups (Weighted if possible)\nSets: 3\nReps: 10-12\nDumbbell Step-Ups\nSets: 3\nReps: 10-12 per leg\nRussian Twists\nSets: 3\nReps: 15-20 per side'
);


--  6th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises, day6_exercises
) 
VALUES (
    '46-60', 'Muscle Gain', 6, 'Intermediate', 
    'Upper Body (Push)\nBarbell Bench Press\nSets: 4\nReps: 6-8\nIncline Dumbbell Press\nSets: 3\nReps: 8-10\nDumbbell Shoulder Press\nSets: 3\nReps: 8-10\nLateral Raises\nSets: 3\nReps: 10-12\nTricep Dips (Weighted if possible)\nSets: 3\nReps: 6-8\nOverhead Tricep Extension (Dumbbell or EZ Bar)\nSets: 3\nReps: 10-12', 
    'Lower Body\nBarbell Squats\nSets: 4\nReps: 6-8\nRomanian Deadlifts\nSets: 3\nReps: 8-10\nLeg Press (Machine)\nSets: 3\nReps: 8-10\nWalking Lunges (Dumbbell)\nSets: 3\nReps: 10-12 per leg\nCalf Raises (Seated or Standing)\nSets: 4\nReps: 10-12\nLeg Curls (Machine)\nSets: 3\nReps: 10-12', 
    'Upper Body (Pull)\nPull-Ups (Assisted if necessary)\nSets: 4\nReps: 6-8\nBent Over Barbell Rows\nSets: 4\nReps: 8-10\nSeated Cable Rows\nSets: 3\nReps: 10-12\nFace Pulls\nSets: 3\nReps: 10-12\nBarbell Bicep Curls\nSets: 3\nReps: 8-10\nHammer Curls\nSets: 3\nReps: 10-12', 
    'Legs & Core\nDeadlifts (Conventional or Sumo)\nSets: 4\nReps: 6-8\nBulgarian Split Squats\nSets: 3\nReps: 10-12 per leg\nLeg Extensions (Machine)\nSets: 3\nReps: 10-12\nPlank\nSets: 3\nDuration: 30-60 sec\nHanging Leg Raises\nSets: 3\nReps: 10-12\nSeated Calf Raises\nSets: 3\nReps: 10-12', 
    'Full Body\nClean and Press\nSets: 4\nReps: 6-8\nKettlebell Swings\nSets: 3\nReps: 10-12\nPush-Ups (Weighted if possible)\nSets: 3\nReps: 10-12\nDumbbell Step-Ups\nSets: 3\nReps: 10-12 per leg\nRussian Twists\nSets: 3\nReps: 15-20 per side',
    'Active Recovery\nLight Yoga or Stretching\nDuration: 30-40 min\nWalking or Light Jogging\nDuration: 20-30 min (easy pace)\nGentle Swimming or Cycling\nDuration: 20-30 min'
);


--  7th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises
) 
VALUES (
    '46-60', 'Weight Loss', 4, 'Intermediate', 
    'Upper Body\nPush-Ups (Knee or Standard)\nSets: 3\nReps: 10-15\nDumbbell Bench Press\nSets: 3\nReps: 10-12\nDumbbell Shoulder Press\nSets: 3\nReps: 10-12\nBent Over Dumbbell Rows\nSets: 3\nReps: 10-12\nLateral Raises\nSets: 3\nReps: 10-15\nTricep Dips (Bench)\nSets: 3\nReps: 10-12', 
    'Lower Body\nBodyweight Squats\nSets: 4\nReps: 12-15\nLunges (Walking or Stationary)\nSets: 3\nReps: 10-12 per leg\nGlute Bridges\nSets: 3\nReps: 12-15\nLeg Press (Machine)\nSets: 3\nReps: 10-12\nCalf Raises (Standing or Seated)\nSets: 4\nReps: 12-15\nLeg Curls (Machine)\nSets: 3\nReps: 10-12', 
    'Full Body & Cardio\nCircuit Training (Repeat 2-3 times)\nBurpees\nReps: 8-10\nKettlebell Swings\nReps: 12-15\nMountain Climbers\nDuration: 30-45 sec\nDumbbell Clean and Press\nReps: 8-10\nJumping Jacks\nDuration: 30-45 sec\nPlank\nDuration: 30-45 sec\nRest for 1-2 minutes between circuits.', 
    'Core & Flexibility\nPlank Variations (Front, Side)\nSets: 3\nDuration: 30-60 sec each\nRussian Twists\nSets: 3\nReps: 15-20 per side\nLeg Raises\nSets: 3\nReps: 10-15\nBicycle Crunches\nSets: 3\nReps: 12-15 per side\nCool Down Stretching or Yoga\nDuration: 15-20 min'
);


--  8th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises
) 
VALUES (
    '46-60', 'Weight Loss', 5, 'Intermediate', 
    'Upper Body\nPush-Ups (Knee or Standard)\nSets: 3\nReps: 10-15\nDumbbell Bench Press\nSets: 3\nReps: 10-12\nDumbbell Shoulder Press\nSets: 3\nReps: 10-12\nBent Over Dumbbell Rows\nSets: 3\nReps: 10-12\nLateral Raises\nSets: 3\nReps: 10-15\nTricep Dips (Bench)\nSets: 3\nReps: 10-12', 
    'Lower Body\nBodyweight Squats\nSets: 4\nReps: 12-15\nWalking Lunges\nSets: 3\nReps: 10-12 per leg\nGlute Bridges\nSets: 3\nReps: 12-15\nLeg Press (Machine)\nSets: 3\nReps: 10-12\nCalf Raises (Standing or Seated)\nSets: 4\nReps: 12-15\nLeg Curls (Machine)\nSets: 3\nReps: 10-12', 
    'Cardio & Core\nInterval Training (30 min)\nChoose one: Treadmill, Stationary Bike, or Elliptical\nAlternate 1 min high intensity with 2 min low intensity\nCore Circuit (Repeat 2-3 times)\nPlank\nDuration: 30-45 sec\nRussian Twists\nReps: 15-20 per side\nLeg Raises\nReps: 10-15\nBicycle Crunches\nReps: 12-15 per side', 
    'Full Body\nCircuit Training (Repeat 2-3 times)\nBurpees\nReps: 8-10\nKettlebell Swings\nReps: 12-15\nDumbbell Clean and Press\nReps: 8-10\nMountain Climbers\nDuration: 30-45 sec\nJumping Jacks\nDuration: 30-45 sec\nPlank\nDuration: 30-45 sec\nRest for 1-2 minutes between circuits.', 
    'Flexibility & Recovery\nDynamic Stretching or Yoga\nDuration: 30-40 min\nFoam Rolling\nFocus on major muscle groups\nDuration: 10-15 min\nLight Cardio\nChoose one: Walking, Swimming, or Cycling\nDuration: 20-30 min at an easy pace'
);


--  9th data 
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises, day6_exercises
) 
VALUES (
    '46-60', 'Weight Loss', 6, 'Intermediate', 
    'Upper Body\nPush-Ups (Knee or Standard)\nSets: 3\nReps: 10-15\nDumbbell Bench Press\nSets: 3\nReps: 10-12\nDumbbell Shoulder Press\nSets: 3\nReps: 10-12\nBent Over Dumbbell Rows\nSets: 3\nReps: 10-12\nLateral Raises\nSets: 3\nReps: 10-15\nTricep Dips (Bench)\nSets: 3\nReps: 10-12', 
    'Lower Body\nBodyweight Squats\nSets: 4\nReps: 12-15\nWalking Lunges\nSets: 3\nReps: 10-12 per leg\nGlute Bridges\nSets: 3\nReps: 12-15\nLeg Press (Machine)\nSets: 3\nReps: 10-12\nCalf Raises (Standing or Seated)\nSets: 4\nReps: 12-15\nLeg Curls (Machine)\nSets: 3\nReps: 10-12', 
    'Cardio Intervals\nInterval Training (30-40 min)\nChoose one: Treadmill, Stationary Bike, or Elliptical\nAlternate 1 min high intensity with 2 min low intensity\nCool Down and Stretching\nDuration: 10-15 min', 
    'Full Body Strength\nCircuit Training (Repeat 2-3 times)\nBurpees\nReps: 8-10\nKettlebell Swings\nReps: 12-15\nDumbbell Clean and Press\nReps: 8-10\nMountain Climbers\nDuration: 30-45 sec\nJumping Jacks\nDuration: 30-45 sec\nPlank\nDuration: 30-45 sec\nRest for 1-2 minutes between circuits.', 
    'Core & Flexibility\nCore Circuit (Repeat 2-3 times)\nPlank Variations (Front, Side)\nDuration: 30-45 sec each\nRussian Twists\nReps: 15-20 per side\nLeg Raises\nReps: 10-15\nBicycle Crunches\nReps: 12-15 per side\nFlexibility & Stretching\nDuration: 20-30 min',
    'Cardio & Active Recovery\nLow-Impact Cardio\nChoose one: Walking, Swimming, or Cycling\nDuration: 30-45 min at an easy pace\nFoam Rolling or Yoga\nDuration: 15-20 min'
);


--  10th data 
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises
) 
VALUES (
    '46-60', 'Improve Endurance', 4, 'Intermediate', 
    'Aerobic Conditioning\nSteady-State Cardio (Choose One)\nBrisk Walking: 45-60 min\nCycling: 45-60 min at moderate intensity\nSwimming: 30-45 min at a comfortable pace\nCool Down and Stretching\nDuration: 10-15 min', 
    'Strength Training with Endurance Focus\nCircuit (Repeat 2-3 times)\nPush-Ups (Knee or Standard)\nReps: 10-15\nBodyweight Squats\nReps: 12-15\nDumbbell Shoulder Press\nReps: 10-12\nWalking Lunges\nReps: 10-12 per leg\nBent Over Dumbbell Rows\nReps: 10-12\nPlank\nDuration: 30-45 sec\nRest for 1-2 minutes between circuits.', 
    'Cardio Intervals\nInterval Training (30-40 min)\nTreadmill or Stationary Bike:\nAlternate 1 min high intensity with 2 min low intensity\nCool Down\nDuration: 10-15 min\nCore Workout\nRussian Twists\nReps: 15-20 per side\nLeg Raises\nReps: 10-15\nBicycle Crunches\nReps: 12-15 per side', 
    'Full Body Circuit\nCircuit (Repeat 2-3 times)\nBurpees\nReps: 6-8\nKettlebell Swings\nReps: 12-15\nDumbbell Clean and Press\nReps: 8-10\nMountain Climbers\nDuration: 30-45 sec\nJumping Jacks\nDuration: 30-45 sec\nPlank with Shoulder Taps\nReps: 10-12 per side\nRest for 1-2 minutes between circuits.'
);


--  11th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises
) 
VALUES (
    '46-60', 'Improve Endurance', 5, 'Intermediate', 
    'Aerobic Conditioning\nSteady-State Cardio (Choose One)\nBrisk Walking: 45-60 min\nCycling: 45-60 min at moderate intensity\nSwimming: 30-45 min at a comfortable pace\nCool Down and Stretching\nDuration: 10-15 min', 
    'Strength Training with Endurance Focus\nCircuit (Repeat 2-3 times)\nPush-Ups (Knee or Standard)\nReps: 10-15\nBodyweight Squats\nReps: 12-15\nDumbbell Shoulder Press\nReps: 10-12\nWalking Lunges\nReps: 10-12 per leg\nBent Over Dumbbell Rows\nReps: 10-12\nPlank\nDuration: 30-45 sec\nRest for 1-2 minutes between circuits.', 
    'Cardio Intervals\nInterval Training (30-40 min)\nTreadmill or Stationary Bike:\nAlternate 1 min high intensity with 2 min low intensity\nCool Down\nDuration: 10-15 min\nCore Workout\nRussian Twists\nReps: 15-20 per side\nLeg Raises\nReps: 10-15\nBicycle Crunches\nReps: 12-15 per side', 
    'Full Body Circuit\nCircuit (Repeat 2-3 times)\nBurpees\nReps: 6-8\nKettlebell Swings\nReps: 12-15\nDumbbell Clean and Press\nReps: 8-10\nMountain Climbers\nDuration: 30-45 sec\nJumping Jacks\nDuration: 30-45 sec\nPlank with Shoulder Taps\nReps: 10-12 per side\nRest for 1-2 minutes between circuits.', 
    'Active Recovery & Flexibility\nLow-Impact Cardio\nChoose one: Walking, Cycling, or Swimming\nDuration: 30-45 min at an easy pace\nFlexibility and Stretching Routine\nDuration: 20-30 min\nFocus on major muscle groups, including:\nHamstrings\nQuadriceps\nShoulders\nBack'
);


--  12th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises, day6_exercises
) 
VALUES (
    '46-60', 'Improve Endurance', 6, 'Intermediate', 
    'Steady-State Cardio\nChoose One:\nBrisk Walking: 45-60 min\nCycling: 45-60 min at moderate intensity\nSwimming: 30-45 min at a comfortable pace\nCool Down and Stretching\nDuration: 10-15 min', 
    'Strength Training with Endurance Focus\nCircuit (Repeat 2-3 times)\nPush-Ups (Knee or Standard)\nReps: 10-15\nBodyweight Squats\nReps: 12-15\nDumbbell Shoulder Press\nReps: 10-12\nWalking Lunges\nReps: 10-12 per leg\nBent Over Dumbbell Rows\nReps: 10-12\nPlank\nDuration: 30-45 sec\nRest for 1-2 minutes between circuits.', 
    'Cardio Intervals\nInterval Training (30-40 min)\nTreadmill or Stationary Bike:\nAlternate 1 min high intensity with 2 min low intensity\nCool Down\nDuration: 10-15 min\nCore Workout\nRussian Twists\nReps: 15-20 per side\nLeg Raises\nReps: 10-15\nBicycle Crunches\nReps: 12-15 per side', 
    'Full Body Circuit\nCircuit (Repeat 2-3 times)\nBurpees\nReps: 6-8\nKettlebell Swings\nReps: 12-15\nDumbbell Clean and Press\nReps: 8-10\nMountain Climbers\nDuration: 30-45 sec\nJumping Jacks\nDuration: 30-45 sec\nPlank with Shoulder Taps\nReps: 10-12 per side\nRest for 1-2 minutes between circuits.', 
    'Active Recovery & Flexibility\nLow-Impact Cardio\nChoose one: Walking, Cycling, or Swimming\nDuration: 30-45 min at an easy pace\nFlexibility and Stretching Routine\nDuration: 20-30 min\nFocus on major muscle groups, including:\nHamstrings\nQuadriceps\nShoulders\nBack', 
    'Mixed Cardio\nCircuit (Repeat 2-3 times)\nJump Rope\nDuration: 1 min\nHigh Knees\nDuration: 30-45 sec\nShadow Boxing\nDuration: 1 min\nStair Climbing or Step-Ups\nDuration: 1 min\nCool Down\nDuration: 10-15 min'
);


--  13th data 
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises
) 
VALUES (
    '46-60', 'Enhanced Flexibility', 4, 'Intermediate', 
    'Flexibility and Mobility\nWarm-Up (10 min)\nDynamic stretches: Arm circles, leg swings, and torso twists.\nFlexibility Routine (40 min)\nStanding Forward Bend\nHold: 30-45 sec\nLunging Hip Flexor Stretch\nHold: 30-45 sec per side\nSeated Hamstring Stretch\nHold: 30-45 sec per side\nChild’s Pose\nHold: 30-45 sec\nCat-Cow Stretch\nDuration: 1 min\nButterfly Stretch\nHold: 30-45 sec\nTorso Rotation Stretch\nHold: 30-45 sec per side\nShoulder Stretch\nHold: 30-45 sec per side\nCool Down (10 min)\nDeep breathing and light stretching.', 
    'Strength and Flexibility\nWarm-Up (10 min)\nDynamic stretches: Arm swings, hip circles, and leg swings.\nStrength with Flexibility Focus (40 min)\nGoblet Squats\nReps: 10-12\nDumbbell Lateral Lunges\nReps: 10-12 per side\nKettlebell Deadlifts\nReps: 10-12\nDumbbell Bench Press\nReps: 10-12\nStanding Calf Raises\nReps: 12-15\nCool Down Stretches (same as Day 1)', 
    'Dynamic Stretching and Core\nWarm-Up (10 min)\nDynamic stretches: High knees, butt kicks, and lateral shuffles.\nDynamic Stretching Routine (30 min)\nLeg Swings (Front to Back)\nReps: 10-15 per leg\nWalking Lunges with a Twist\nReps: 10-12 per leg\nInchworms\nReps: 8-10\nHip Openers\nReps: 10-12 per side\nArm Crosses\nReps: 10-12\nTorso Rotations\nDuration: 1 min\nCore Routine (20 min)\nPlank\nDuration: 30-60 sec\nSide Plank\nDuration: 30-45 sec per side\nBird-Dog\nReps: 10-12 per side\nRussian Twists\nReps: 12-15 per side', 
    'Active Recovery and Yoga\nLow-Intensity Cardio (Optional, 20-30 min)\nWalking or cycling at an easy pace.\nYoga Session (30-40 min)\nChild\'s Pose\nDownward Facing Dog\nWarrior I\nWarrior II\nTriangle Pose\nSeated Forward Bend\nReclining Bound Angle Pose\nCorpse Pose for relaxation (5-10 min)'
);


-14th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises
) 
VALUES (
    '46-60', 'Enhanced Flexibility', 5, 'Intermediate', 
    'Flexibility and Mobility\nWarm-Up (10 min)\nDynamic stretches: Arm circles, leg swings, and torso twists.\nFlexibility Routine (40 min)\nStanding Forward Bend\nHold: 30-45 sec\nLunging Hip Flexor Stretch\nHold: 30-45 sec per side\nSeated Hamstring Stretch\nHold: 30-45 sec per side\nChild’s Pose\nHold: 30-45 sec\nCat-Cow Stretch\nDuration: 1 min\nButterfly Stretch\nHold: 30-45 sec\nTorso Rotation Stretch\nHold: 30-45 sec per side\nShoulder Stretch\nHold: 30-45 sec per side\nCool Down (10 min)\nDeep breathing and light stretching.', 
    'Strength and Flexibility\nWarm-Up (10 min)\nDynamic stretches: Arm swings, hip circles, and leg swings.\nStrength with Flexibility Focus (40 min)\nGoblet Squats\nReps: 10-12\nDumbbell Lateral Lunges\nReps: 10-12 per side\nKettlebell Deadlifts\nReps: 10-12\nDumbbell Bench Press\nReps: 10-12\nStanding Calf Raises\nReps: 12-15\nCool Down Stretches (same as Day 1)', 
    'Dynamic Stretching and Core\nWarm-Up (10 min)\nDynamic stretches: High knees, butt kicks, and lateral shuffles.\nDynamic Stretching Routine (30 min)\nLeg Swings (Front to Back)\nReps: 10-15 per leg\nWalking Lunges with a Twist\nReps: 10-12 per leg\nInchworms\nReps: 8-10\nHip Openers\nReps: 10-12 per side\nArm Crosses\nReps: 10-12\nTorso Rotations\nDuration: 1 min\nCore Routine (20 min)\nPlank\nDuration: 30-60 sec\nSide Plank\nDuration: 30-45 sec per side\nBird-Dog\nReps: 10-12 per side\nRussian Twists\nReps: 12-15 per side', 
    'Yoga and Balance\nWarm-Up (10 min)\nGentle dynamic stretching.\nYoga Routine (40 min)\nMountain Pose\nDownward Facing Dog\nWarrior I\nWarrior II\nTriangle Pose\nTree Pose (for balance)\nSeated Forward Bend\nReclining Bound Angle Pose\nCorpse Pose for relaxation (5-10 min)', 
    'Active Recovery and Full Body Flexibility\nLow-Intensity Cardio (Optional, 20-30 min)\nWalking or cycling at an easy pace.\nFull Body Flexibility Routine (40 min)\nSeated Forward Fold\nHold: 30-45 sec\nKneeling Hip Flexor Stretch\nHold: 30-45 sec per side\nSpinal Twist\nHold: 30-45 sec per side\nPigeon Pose\nHold: 30-45 sec per side\nWall Chest Stretch\nHold: 30-45 sec\nSeated Side Bend\nHold: 30-45 sec per side\nStanding Quadriceps Stretch\nHold: 30-45 sec per side'
);


--  15th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises, day6_exercises
) 
VALUES (
    '46-60', 'Enhanced Flexibility', 6, 'Intermediate', 
    'Flexibility and Mobility\nWarm-Up (10 min)\nDynamic stretches: Arm circles, leg swings, and torso twists.\nFlexibility Routine (40 min)\nStanding Forward Bend\nHold: 30-45 sec\nLunging Hip Flexor Stretch\nHold: 30-45 sec per side\nSeated Hamstring Stretch\nHold: 30-45 sec per side\nChild’s Pose\nHold: 30-45 sec\nCat-Cow Stretch\nDuration: 1 min\nButterfly Stretch\nHold: 30-45 sec\nTorso Rotation Stretch\nHold: 30-45 sec per side\nShoulder Stretch\nHold: 30-45 sec per side\nCool Down (10 min)\nDeep breathing and light stretching.', 
    'Strength and Flexibility\nWarm-Up (10 min)\nDynamic stretches: Arm swings, hip circles, and leg swings.\nStrength with Flexibility Focus (40 min)\nGoblet Squats\nReps: 10-12\nDumbbell Lateral Lunges\nReps: 10-12 per side\nKettlebell Deadlifts\nReps: 10-12\nDumbbell Bench Press\nReps: 10-12\nStanding Calf Raises\nReps: 12-15\nCool Down Stretches (same as Day 1)', 
    'Dynamic Stretching and Core\nWarm-Up (10 min)\nDynamic stretches: High knees, butt kicks, and lateral shuffles.\nDynamic Stretching Routine (30 min)\nLeg Swings (Front to Back)\nReps: 10-15 per leg\nWalking Lunges with a Twist\nReps: 10-12 per leg\nInchworms\nReps: 8-10\nHip Openers\nReps: 10-12 per side\nArm Crosses\nReps: 10-12\nTorso Rotations\nDuration: 1 min\nCore Routine (20 min)\nPlank\nDuration: 30-60 sec\nSide Plank\nDuration: 30-45 sec per side\nBird-Dog\nReps: 10-12 per side\nRussian Twists\nReps: 12-15 per side', 
    'Yoga and Balance\nWarm-Up (10 min)\nGentle dynamic stretching.\nYoga Routine (40 min)\nMountain Pose\nDownward Facing Dog\nWarrior I\nWarrior II\nTriangle Pose\nTree Pose (for balance)\nSeated Forward Bend\nReclining Bound Angle Pose\nCorpse Pose for relaxation (5-10 min)', 
    'Active Recovery and Full Body Flexibility\nLow-Intensity Cardio (Optional, 20-30 min)\nWalking or cycling at an easy pace.\nFull Body Flexibility Routine (40 min)\nSeated Forward Fold\nHold: 30-45 sec\nKneeling Hip Flexor Stretch\nHold: 30-45 sec per side\nSpinal Twist\nHold: 30-45 sec per side\nPigeon Pose\nHold: 30-45 sec per side\nWall Chest Stretch\nHold: 30-45 sec\nSeated Side Bend\nHold: 30-45 sec per side\nStanding Quadriceps Stretch\nHold: 30-45 sec per side',
    'Combination of Flexibility and Low-Intensity Cardio\nWarm-Up (10 min)\nGentle dynamic stretching.\nLow-Intensity Cardio (20-30 min)\nChoose one: Walking, cycling, or swimming at an easy pace.\nFlexibility Routine (30 min)\nStanding Forward Bend\nHold: 30-45 sec\nLunging Hip Flexor Stretch\nHold: 30-45 sec per side\nCat-Cow Stretch\nDuration: 1 min\nChild’s Pose\nHold: 30-45 sec\nButterfly Stretch\nHold: 30-45 sec\nSupine Spinal Twist\nHold: 30-45 sec per side\nSitting Straddle Stretch\nHold: 30-45 sec'
);


-16th data 
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises
) 
VALUES (
    '31-45', 'Weight Loss', 4, 'Intermediate', 
    'Full Body Strength and Cardio\nWarm-Up (10 min)\nDynamic stretches: Arm circles, leg swings, and torso twists.\nStrength Circuit (30 min)\nPerform 3 rounds of the following exercises:\nGoblet Squats\nReps: 10-12\nPush-Ups\nReps: 10-12\nBent-Over Dumbbell Rows\nReps: 10-12\nDumbbell Lunges\nReps: 10-12 per leg\nPlank to Shoulder Taps\nReps: 10-12 per side\nCardio (20 min)\nInterval Training on Treadmill or Bike:\n1 min high intensity, 2 min low intensity (repeat for 20 min)\nCool Down (10 min)\nStatic stretches focusing on major muscle groups.', 
    'HIIT (High-Intensity Interval Training)\nWarm-Up (10 min)\nDynamic stretches: Jumping jacks, arm swings, leg swings.\nHIIT Workout (30 min)\nPerform 5 rounds of the following exercises, 30 seconds on, 30 seconds off:\nBurpees\nMountain Climbers\nJump Squats\nHigh Knees\nPush-Ups\nCool Down (10 min)\nStatic stretches focusing on flexibility and muscle recovery.', 
    'Strength Training (Upper Body Focus)\nWarm-Up (10 min)\nDynamic stretches: Arm circles, torso twists, and light cardio.\nUpper Body Strength Circuit (40 min)\nPerform 3 rounds of the following exercises:\nBench Press (Dumbbell or Barbell)\nReps: 10-12\nPull-Ups or Assisted Pull-Ups\nReps: 6-10\nDumbbell Shoulder Press\nReps: 10-12\nTricep Dips\nReps: 8-10\nBicep Curls\nReps: 10-12\nPlank (for core engagement)\nDuration: 30-60 sec\nCool Down (10 min)\nStatic stretches focusing on upper body flexibility.', 
    'Active Recovery and Flexibility\nLow-Intensity Cardio (Optional, 20-30 min)\nWalking, cycling, or swimming at a comfortable pace.\nFlexibility Routine (30 min)\nStanding Forward Bend\nHold: 30-45 sec\nSeated Hamstring Stretch\nHold: 30-45 sec per side\nLunging Hip Flexor Stretch\nHold: 30-45 sec per side\nChild’s Pose\nHold: 30-45 sec\nFigure Four Stretch\nHold: 30-45 sec per side\nCat-Cow Stretch\nDuration: 1 min\nCool Down (10 min)\nDeep breathing and light stretching.'
);


--  17th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises
) 
VALUES (
    '31-45', 'Weight Loss', 5, 'Intermediate', 
    'Full Body Strength\nWarm-Up (10 min)\nDynamic stretches: Arm circles, leg swings, and torso twists.\nFull Body Strength Circuit (40 min)\nPerform 3 rounds of the following exercises:\nGoblet Squats\nReps: 10-12\nPush-Ups\nReps: 10-12\nBent-Over Dumbbell Rows\nReps: 10-12\nDumbbell Lunges\nReps: 10-12 per leg\nPlank to Shoulder Taps\nReps: 10-12 per side\nCool Down (10 min)\nStatic stretches focusing on major muscle groups.', 
    'Cardio and Core\nWarm-Up (10 min)\nDynamic stretches: Jumping jacks, arm swings, leg swings.\nCardio Workout (30 min)\nInterval Training on Treadmill or Bike:\n1 min high intensity, 2 min low intensity (repeat for 20 min)\nSteady-State Cardio:\n10 min moderate pace.\nCore Routine (20 min)\nPerform 2 rounds of the following exercises:\nPlank\nDuration: 30-60 sec\nRussian Twists\nReps: 12-15 per side\nLeg Raises\nReps: 10-12\nSide Plank\nDuration: 30-45 sec per side\nCool Down (10 min)\nStatic stretches focusing on core flexibility.', 
    'Upper Body Strength and HIIT\nWarm-Up (10 min)\nDynamic stretches: Arm circles, torso twists, and light cardio.\nUpper Body Strength Circuit (30 min)\nPerform 3 rounds of the following exercises:\nDumbbell Bench Press\nReps: 10-12\nPull-Ups or Assisted Pull-Ups\nReps: 6-10\nDumbbell Shoulder Press\nReps: 10-12\nTricep Dips\nReps: 8-10\nDumbbell Bicep Curls\nReps: 10-12\nHIIT Workout (20 min)\nPerform 5 rounds of the following exercises, 30 seconds on, 30 seconds off:\nBurpees\nJump Squats\nHigh Knees\nMountain Climbers\nPush-Ups\nCool Down (10 min)\nStatic stretches focusing on upper body flexibility.', 
    'Lower Body Strength\nWarm-Up (10 min)\nDynamic stretches: Leg swings, bodyweight squats, and hip circles.\nLower Body Strength Circuit (40 min)\nPerform 3 rounds of the following exercises:\nBarbell or Dumbbell Squats\nReps: 10-12\nDeadlifts (Romanian or Conventional)\nReps: 10-12\nLeg Press (Machine)\nReps: 10-12\nWalking Lunges\nReps: 10-12 per leg\nCalf Raises\nReps: 12-15\nCool Down (10 min)\nStatic stretches focusing on lower body flexibility.', 
    'Active Recovery and Flexibility\nLow-Intensity Cardio (Optional, 20-30 min)\nChoose one: Walking, cycling, or swimming at a comfortable pace.\nFlexibility Routine (30 min)\nStanding Forward Bend\nHold: 30-45 sec\nSeated Hamstring Stretch\nHold: 30-45 sec per side\nLunging Hip Flexor Stretch\nHold: 30-45 sec per side\nChild’s Pose\nHold: 30-45 sec\nFigure Four Stretch\nHold: 30-45 sec per side\nCat-Cow Stretch\nDuration: 1 min\nCool Down (10 min)\nDeep breathing and light stretching.'
);


--  18th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises, day6_exercises
) 
VALUES (
    '31-45', 'Weight Loss', 6, 'Intermediate', 
    'Full Body Strength\nWarm-Up (10 min)\nDynamic stretches: Arm circles, leg swings, and torso twists.\nFull Body Strength Circuit (40 min)\nPerform 3 rounds of the following exercises:\nGoblet Squats\nReps: 10-12\nPush-Ups\nReps: 10-12\nBent-Over Dumbbell Rows\nReps: 10-12\nDumbbell Lunges\nReps: 10-12 per leg\nPlank to Shoulder Taps\nReps: 10-12 per side\nCool Down (10 min)\nStatic stretches focusing on major muscle groups.', 
    'Cardio and Core\nWarm-Up (10 min)\nDynamic stretches: Jumping jacks, arm swings, leg swings.\nCardio Workout (30 min)\nInterval Training on Treadmill or Bike:\n1 min high intensity, 2 min low intensity (repeat for 20 min)\nSteady-State Cardio:\n10 min moderate pace.\nCore Routine (20 min)\nPerform 3 rounds of the following exercises:\nPlank\nDuration: 30-60 sec\nRussian Twists\nReps: 15 per side\nLeg Raises\nReps: 10-12\nBicycle Crunches\nReps: 12-15 per side\nCool Down (10 min)\nStatic stretches focusing on core flexibility.', 
    'Upper Body Strength and HIIT\nWarm-Up (10 min)\nDynamic stretches: Arm circles, torso twists, and light cardio.\nUpper Body Strength Circuit (30 min)\nPerform 3 rounds of the following exercises:\nDumbbell Bench Press\nReps: 10-12\nPull-Ups or Assisted Pull-Ups\nReps: 6-10\nDumbbell Shoulder Press\nReps: 10-12\nTricep Dips\nReps: 8-10\nDumbbell Bicep Curls\nReps: 10-12\nHIIT Workout (20 min)\nPerform 5 rounds of the following exercises, 30 seconds on, 30 seconds off:\nBurpees\nJump Squats\nHigh Knees\nMountain Climbers\nPush-Ups\nCool Down (10 min)\nStatic stretches focusing on upper body flexibility.', 
    'Lower Body Strength\nWarm-Up (10 min)\nDynamic stretches: Leg swings, bodyweight squats, and hip circles.\nLower Body Strength Circuit (40 min)\nPerform 3 rounds of the following exercises:\nBarbell or Dumbbell Squats\nReps: 10-12\nDeadlifts (Romanian or Conventional)\nReps: 10-12\nLeg Press (Machine)\nReps: 10-12\nWalking Lunges\nReps: 10-12 per leg\nCalf Raises\nReps: 12-15\nCool Down (10 min)\nStatic stretches focusing on lower body flexibility.', 
    'Active Recovery and Flexibility\nLow-Intensity Cardio (Optional, 20-30 min)\nChoose one: Walking, cycling, or swimming at a comfortable pace.\nFlexibility Routine (30 min)\nStanding Forward Bend\nHold: 30-45 sec\nSeated Hamstring Stretch\nHold: 30-45 sec per side\nLunging Hip Flexor Stretch\nHold: 30-45 sec per side\nChild’s Pose\nHold: 30-45 sec\nFigure Four Stretch\nHold: 30-45 sec per side\nCat-Cow Stretch\nDuration: 1 min\nCool Down (10 min)\nDeep breathing and light stretching.',
    'Full Body Circuit and Conditioning\nWarm-Up (10 min)\nDynamic stretches: High knees, butt kicks, and side lunges.\nFull Body Circuit (40 min)\nPerform 3 rounds of the following exercises:\nKettlebell Swings\nReps: 12-15\nThrusters (Dumbbell or Barbell)\nReps: 10-12\nBox Jumps\nReps: 8-10\nDumbbell Renegade Rows\nReps: 8-10 per side\nBattle Ropes (if available)\nDuration: 30-45 sec\nConditioning Finisher (10 min)\n5-minute treadmill run or jog at a moderate pace.\nFollowed by 5 minutes of alternating between 30 seconds of sprinting and 30 seconds of walking.\nCool Down (10 min)\nStatic stretches focusing on overall flexibility.'
);


--  19th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises
) 
VALUES (
    '31-45', 'Muscle Gain', 4, 'Intermediate', 
    'Upper Body (Push)\nWarm-Up (10 min)\nDynamic stretches: Arm circles, chest openers, and light push-ups.\nUpper Body Strength Circuit (40 min)\nPerform 4 sets of the following exercises:\nBarbell Bench Press\nReps: 8-10\nIncline Dumbbell Press\nReps: 10-12\nDumbbell Shoulder Press\nReps: 8-10\nLateral Raises\nReps: 12-15\nTricep Dips (Weighted if possible)\nReps: 8-10\nOverhead Tricep Extension (Dumbbell or EZ Bar)\nReps: 10-12\nCool Down (10 min)\nStatic stretches focusing on upper body muscles.', 
    'Lower Body\nWarm-Up (10 min)\nDynamic stretches: Leg swings, bodyweight squats, and lunges.\nLower Body Strength Circuit (40 min)\nPerform 4 sets of the following exercises:\nBarbell Squats\nReps: 8-10\nRomanian Deadlifts\nReps: 8-10\nLeg Press (Machine)\nReps: 10-12\nLunges (Dumbbell or Barbell)\nReps: 10-12 per leg\nCalf Raises (Standing or Seated)\nReps: 12-15\nLeg Curls (Machine)\nReps: 10-12\nCool Down (10 min)\nStatic stretches focusing on lower body muscles.', 
    'Upper Body (Pull)\nWarm-Up (10 min)\nDynamic stretches: Arm swings, torso twists, and light cardio.\nUpper Body Strength Circuit (40 min)\nPerform 4 sets of the following exercises:\nPull-Ups (Assisted if necessary)\nReps: 6-8\nBent-Over Barbell Rows\nReps: 8-10\nSeated Cable Rows\nReps: 10-12\nFace Pulls\nReps: 12-15\nBarbell Bicep Curls\nReps: 10-12\nHammer Curls\nReps: 10-12\nCool Down (10 min)\nStatic stretches focusing on upper body muscles.', 
    'Legs & Core\nWarm-Up (10 min)\nDynamic stretches: Leg swings, high knees, and butt kicks.\nLegs & Core Circuit (40 min)\nPerform 4 sets of the following exercises:\nDeadlifts (Conventional or Sumo)\nReps: 6-8\nBulgarian Split Squats\nReps: 10-12 per leg\nLeg Extensions (Machine)\nReps: 10-12\nSeated Calf Raises\nReps: 12-15\nPlank\nDuration: 30-60 sec\nHanging Leg Raises\nReps: 10-12\nCool Down (10 min)\nStatic stretches focusing on legs and core.'
);


--  20th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises
) 
VALUES (
    '31-45', 'Muscle Gain', 5, 'Intermediate', 
    'Upper Body (Push)\nWarm-Up (10 min)\nDynamic stretches: Arm circles, chest openers, and light push-ups.\nUpper Body Strength Circuit (40 min)\nPerform 4 sets of the following exercises:\nBarbell Bench Press\nReps: 8-10\nIncline Dumbbell Press\nReps: 10-12\nDumbbell Shoulder Press\nReps: 8-10\nLateral Raises\nReps: 12-15\nTricep Dips (Weighted if possible)\nReps: 8-10\nOverhead Tricep Extension (Dumbbell or EZ Bar)\nReps: 10-12\nCool Down (10 min)\nStatic stretches focusing on upper body muscles.', 
    'Lower Body\nWarm-Up (10 min)\nDynamic stretches: Leg swings, bodyweight squats, and lunges.\nLower Body Strength Circuit (40 min)\nPerform 4 sets of the following exercises:\nBarbell Squats\nReps: 8-10\nRomanian Deadlifts\nReps: 8-10\nLeg Press (Machine)\nReps: 10-12\nWalking Lunges\nReps: 10-12 per leg\nCalf Raises (Standing or Seated)\nReps: 12-15\nLeg Curls (Machine)\nReps: 10-12\nCool Down (10 min)\nStatic stretches focusing on lower body muscles.', 
    'Upper Body (Pull)\nWarm-Up (10 min)\nDynamic stretches: Arm swings, torso twists, and light cardio.\nUpper Body Strength Circuit (40 min)\nPerform 4 sets of the following exercises:\nPull-Ups (Assisted if necessary)\nReps: 6-8\nBent-Over Barbell Rows\nReps: 8-10\nSeated Cable Rows\nReps: 10-12\nFace Pulls\nReps: 12-15\nBarbell Bicep Curls\nReps: 10-12\nHammer Curls\nReps: 10-12\nCool Down (10 min)\nStatic stretches focusing on upper body muscles.', 
    'Legs & Core\nWarm-Up (10 min)\nDynamic stretches: Leg swings, high knees, and butt kicks.\nLegs & Core Circuit (40 min)\nPerform 4 sets of the following exercises:\nDeadlifts (Conventional or Sumo)\nReps: 6-8\nBulgarian Split Squats\nReps: 10-12 per leg\nLeg Extensions (Machine)\nReps: 10-12\nSeated Calf Raises\nReps: 12-15\nPlank\nDuration: 30-60 sec\nHanging Leg Raises\nReps: 10-12\nCool Down (10 min)\nStatic stretches focusing on legs and core.', 
    'Full Body\nWarm-Up (10 min)\nDynamic stretches: High knees, arm circles, and light jogging.\nFull Body Strength Circuit (40 min)\nPerform 3 rounds of the following exercises:\nClean and Press\nReps: 8-10\nKettlebell Swings\nReps: 12-15\nPush-Ups\nReps: 10-12\nDumbbell Step-Ups\nReps: 10-12 per leg\nBattle Ropes (if available)\nDuration: 30-45 sec\nCore Finisher (10 min)\nPerform 3 rounds of the following exercises:\nRussian Twists\nReps: 15 per side\nPlank Jacks\nReps: 10-15\nBicycle Crunches\nReps: 12-15 per side\nCool Down (10 min)\nStatic stretches focusing on overall flexibility.'
);


--  21st data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises, day6_exercises
) 
VALUES (
    '31-45', 'Muscle Gain', 6, 'Intermediate', 
    'Upper Body (Push)\nWarm-Up (10 min)\nDynamic stretches: Arm circles, chest openers, and light push-ups.\nUpper Body Strength Circuit (40 min)\nPerform 4 sets of the following exercises:\nBarbell Bench Press\nReps: 8-10\nIncline Dumbbell Press\nReps: 10-12\nDumbbell Shoulder Press\nReps: 8-10\nLateral Raises\nReps: 12-15\nTricep Dips (Weighted if possible)\nReps: 8-10\nOverhead Tricep Extension (Dumbbell or EZ Bar)\nReps: 10-12\nCool Down (10 min)\nStatic stretches focusing on upper body muscles.', 
    'Lower Body\nWarm-Up (10 min)\nDynamic stretches: Leg swings, bodyweight squats, and lunges.\nLower Body Strength Circuit (40 min)\nPerform 4 sets of the following exercises:\nBarbell Squats\nReps: 8-10\nRomanian Deadlifts\nReps: 8-10\nLeg Press (Machine)\nReps: 10-12\nWalking Lunges\nReps: 10-12 per leg\nCalf Raises (Standing or Seated)\nReps: 12-15\nLeg Curls (Machine)\nReps: 10-12\nCool Down (10 min)\nStatic stretches focusing on lower body muscles.', 
    'Upper Body (Pull)\nWarm-Up (10 min)\nDynamic stretches: Arm swings, torso twists, and light cardio.\nUpper Body Strength Circuit (40 min)\nPerform 4 sets of the following exercises:\nPull-Ups (Assisted if necessary)\nReps: 6-8\nBent-Over Barbell Rows\nReps: 8-10\nSeated Cable Rows\nReps: 10-12\nFace Pulls\nReps: 12-15\nBarbell Bicep Curls\nReps: 10-12\nHammer Curls\nReps: 10-12\nCool Down (10 min)\nStatic stretches focusing on upper body muscles.', 
    'Legs & Core\nWarm-Up (10 min)\nDynamic stretches: Leg swings, high knees, and butt kicks.\nLegs & Core Circuit (40 min)\nPerform 4 sets of the following exercises:\nDeadlifts (Conventional or Sumo)\nReps: 6-8\nBulgarian Split Squats\nReps: 10-12 per leg\nLeg Extensions (Machine)\nReps: 10-12\nSeated Calf Raises\nReps: 12-15\nPlank\nDuration: 30-60 sec\nHanging Leg Raises\nReps: 10-12\nCool Down (10 min)\nStatic stretches focusing on legs and core.', 
    'Full Body\nWarm-Up (10 min)\nDynamic stretches: High knees, arm circles, and light jogging.\nFull Body Strength Circuit (40 min)\nPerform 4 sets of the following exercises:\nClean and Press\nReps: 8-10\nKettlebell Swings\nReps: 12-15\nPush-Ups\nReps: 10-12\nDumbbell Step-Ups\nReps: 10-12 per leg\nBattle Ropes (if available)\nDuration: 30-45 sec\nCore Finisher (10 min)\nPerform 3 rounds of the following exercises:\nRussian Twists\nReps: 15 per side\nPlank Jacks\nReps: 10-15\nBicycle Crunches\nReps: 12-15 per side\nCool Down (10 min)\nStatic stretches focusing on overall flexibility.', 
    'Active Recovery/Conditioning\nLight Cardio (20-30 min)\nChoose low-impact activities such as walking, cycling, or swimming at a moderate pace.\nMobility and Flexibility (20 min)\nYoga or dynamic stretching routine to enhance flexibility and recovery.\nCool Down (10 min)\nStatic stretches focusing on any tight areas.'
);


--  22nd data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises
) 
VALUES (
    '31-45', 'General Workout', 4, 'Intermediate', 
    'Upper Body (Push)\nWarm-Up (10 min)\nDynamic stretches: Arm circles, chest openers, and light push-ups.\nUpper Body Strength Circuit (40 min)\nPerform 3-4 sets of the following exercises:\nBarbell Bench Press\nReps: 8-10\nIncline Dumbbell Press\nReps: 10-12\nDumbbell Shoulder Press\nReps: 8-10\nLateral Raises\nReps: 12-15\nTricep Dips (Bodyweight or Weighted)\nReps: 8-10\nCool Down (10 min)\nStatic stretches focusing on upper body muscles.', 
    'Lower Body\nWarm-Up (10 min)\nDynamic stretches: Leg swings, bodyweight squats, and lunges.\nLower Body Strength Circuit (40 min)\nPerform 3-4 sets of the following exercises:\nBarbell Squats\nReps: 8-10\nRomanian Deadlifts\nReps: 8-10\nLeg Press (Machine)\nReps: 10-12\nWalking Lunges\nReps: 10-12 per leg\nCalf Raises (Standing or Seated)\nReps: 12-15\nCool Down (10 min)\nStatic stretches focusing on lower body muscles.', 
    'Full Body\nWarm-Up (10 min)\nDynamic stretches: High knees, arm circles, and light jogging.\nFull Body Strength Circuit (40 min)\nPerform 3-4 sets of the following exercises:\nClean and Press\nReps: 8-10\nKettlebell Swings\nReps: 12-15\nPush-Ups\nReps: 10-12\nDumbbell Step-Ups\nReps: 10-12 per leg\nPlank to Push-Up\nReps: 10-12\nCool Down (10 min)\nStatic stretches focusing on overall flexibility.', 
    'Core and Conditioning\nWarm-Up (10 min)\nDynamic stretches: Leg swings, torso twists, and light cardio.\nCore Circuit (30 min)\nPerform 3 sets of the following exercises:\nPlank\nDuration: 30-60 sec\nRussian Twists\nReps: 15 per side\nBicycle Crunches\nReps: 12-15 per side\nLeg Raises\nReps: 10-12\nMountain Climbers\nDuration: 30-45 sec\nConditioning (15-20 min)\nChoose a cardio activity (running, cycling, rowing) and maintain a moderate pace.\nCool Down (10 min)\nStatic stretches focusing on core and overall flexibility.'
);


--  23rd data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises
) 
VALUES (
    '31-45', 'General Workout', 5, 'Intermediate', 
    'Upper Body (Push)\nWarm-Up (10 min)\nDynamic stretches: Arm circles, chest openers, and light push-ups.\nUpper Body Strength Circuit (40 min)\nPerform 4 sets of the following exercises:\nBarbell Bench Press\nReps: 8-10\nIncline Dumbbell Press\nReps: 10-12\nDumbbell Shoulder Press\nReps: 8-10\nLateral Raises\nReps: 12-15\nTricep Dips (Bodyweight or Weighted)\nReps: 8-10\nOverhead Tricep Extension (Dumbbell or EZ Bar)\nReps: 10-12\nCool Down (10 min)\nStatic stretches focusing on upper body muscles.', 
    'Lower Body\nWarm-Up (10 min)\nDynamic stretches: Leg swings, bodyweight squats, and lunges.\nLower Body Strength Circuit (40 min)\nPerform 4 sets of the following exercises:\nBarbell Squats\nReps: 8-10\nRomanian Deadlifts\nReps: 8-10\nLeg Press (Machine)\nReps: 10-12\nWalking Lunges\nReps: 10-12 per leg\nCalf Raises (Standing or Seated)\nReps: 12-15\nCool Down (10 min)\nStatic stretches focusing on lower body muscles.', 
    'Upper Body (Pull)\nWarm-Up (10 min)\nDynamic stretches: Arm swings, torso twists, and light cardio.\nUpper Body Strength Circuit (40 min)\nPerform 4 sets of the following exercises:\nPull-Ups (Assisted if necessary)\nReps: 6-8\nBent-Over Barbell Rows\nReps: 8-10\nSeated Cable Rows\nReps: 10-12\nFace Pulls\nReps: 12-15\nBarbell Bicep Curls\nReps: 10-12\nCool Down (10 min)\nStatic stretches focusing on upper body muscles.', 
    'Legs & Core\nWarm-Up (10 min)\nDynamic stretches: Leg swings, high knees, and butt kicks.\nLegs & Core Circuit (40 min)\nPerform 4 sets of the following exercises:\nDeadlifts (Conventional or Sumo)\nReps: 6-8\nBulgarian Split Squats\nReps: 10-12 per leg\nLeg Extensions (Machine)\nReps: 10-12\nSeated Calf Raises\nReps: 12-15\nPlank\nDuration: 30-60 sec\nHanging Leg Raises\nReps: 10-12\nCool Down (10 min)\nStatic stretches focusing on legs and core.', 
    'Full Body\nWarm-Up (10 min)\nDynamic stretches: High knees, arm circles, and light jogging.\nFull Body Strength Circuit (40 min)\nPerform 4 sets of the following exercises:\nClean and Press\nReps: 8-10\nKettlebell Swings\nReps: 12-15\nPush-Ups (Weighted if possible)\nReps: 10-12\nDumbbell Step-Ups\nReps: 10-12 per leg\nBattle Ropes (if available)\nDuration: 30-45 sec\nCore Finisher (10 min)\nPerform 2 rounds of the following exercises:\nRussian Twists\nReps: 15 per side\nBicycle Crunches\nReps: 12-15 per side\nCool Down (10 min)\nStatic stretches focusing on overall flexibility.'
);


--  24th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises, day6_exercises
) 
VALUES (
    '31-45', 'General Workout', 6, 'Intermediate', 
    'Upper Body (Push)\nWarm-Up (10 min)\nDynamic stretches: Arm circles, shoulder stretches, and light push-ups.\nUpper Body Strength Circuit (40 min)\nPerform 4 sets of the following exercises:\nBarbell Bench Press\nReps: 8-10\nIncline Dumbbell Press\nReps: 10-12\nDumbbell Shoulder Press\nReps: 8-10\nLateral Raises\nReps: 12-15\nTricep Dips (Bodyweight or Weighted)\nReps: 8-10\nOverhead Tricep Extension (Dumbbell or EZ Bar)\nReps: 10-12\nCool Down (10 min)\nStatic stretches focusing on upper body muscles.', 
    'Lower Body\nWarm-Up (10 min)\nDynamic stretches: Leg swings, bodyweight squats, and lunges.\nLower Body Strength Circuit (40 min)\nPerform 4 sets of the following exercises:\nBarbell Squats\nReps: 8-10\nRomanian Deadlifts\nReps: 8-10\nLeg Press (Machine)\nReps: 10-12\nWalking Lunges\nReps: 10-12 per leg\nCalf Raises (Standing or Seated)\nReps: 12-15\nCool Down (10 min)\nStatic stretches focusing on lower body muscles.', 
    'Upper Body (Pull)\nWarm-Up (10 min)\nDynamic stretches: Arm swings, torso twists, and light cardio.\nUpper Body Strength Circuit (40 min)\nPerform 4 sets of the following exercises:\nPull-Ups (Assisted if necessary)\nReps: 6-8\nBent-Over Barbell Rows\nReps: 8-10\nSeated Cable Rows\nReps: 10-12\nFace Pulls\nReps: 12-15\nBarbell Bicep Curls\nReps: 10-12\nCool Down (10 min)\nStatic stretches focusing on upper body muscles.', 
    'Legs & Core\nWarm-Up (10 min)\nDynamic stretches: Leg swings, high knees, and butt kicks.\nLegs & Core Circuit (40 min)\nPerform 4 sets of the following exercises:\nDeadlifts (Conventional or Sumo)\nReps: 6-8\nBulgarian Split Squats\nReps: 10-12 per leg\nLeg Extensions (Machine)\nReps: 10-12\nSeated Calf Raises\nReps: 12-15\nPlank\nDuration: 30-60 sec\nHanging Leg Raises\nReps: 10-12\nCool Down (10 min)\nStatic stretches focusing on legs and core.', 
    'Full Body\nWarm-Up (10 min)\nDynamic stretches: High knees, arm circles, and light jogging.\nFull Body Strength Circuit (40 min)\nPerform 4 sets of the following exercises:\nClean and Press\nReps: 8-10\nKettlebell Swings\nReps: 12-15\nPush-Ups (Weighted if possible)\nReps: 10-12\nDumbbell Step-Ups\nReps: 10-12 per leg\nBattle Ropes (if available)\nDuration: 30-45 sec\nCore Finisher (10 min)\nPerform 2 rounds of the following exercises:\nRussian Twists\nReps: 15 per side\nBicycle Crunches\nReps: 12-15 per side\nCool Down (10 min)\nStatic stretches focusing on overall flexibility.',
    'Conditioning & Core\nWarm-Up (10 min)\nDynamic stretches: Leg swings, torso twists, and light cardio.\nConditioning Circuit (30-40 min)\nChoose any 2-3 activities from the list below and perform them in intervals:\nRunning or Jogging\nDuration: 20-30 min\nRowing Machine\nDuration: 20 min\nCycling\nDuration: 20-30 min\nCore Circuit (20 min)\nPerform 3 sets of the following exercises:\nPlank\nDuration: 30-60 sec\nMountain Climbers\nDuration: 30-45 sec\nSide Plank\nDuration: 30-45 sec each side\nFlutter Kicks\nReps: 15-20\nCool Down (10 min)\nStatic stretches focusing on core and overall flexibility.'
);


--  25th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises
) 
VALUES (
    '31-45', 'Improve Endurance', 4, 'Intermediate', 
    'Endurance Strength Training\nWarm-Up (10 min)\nDynamic stretches: Arm circles, leg swings, and light cardio (jogging or jump rope).\nEndurance Strength Circuit (40 min)\nPerform 3 sets of the following exercises with lighter weights and higher reps:\nBarbell Squats\nReps: 12-15\nPush-Ups (Regular or Knee)\nReps: 10-15\nDumbbell Deadlifts\nReps: 12-15\nStanding Dumbbell Shoulder Press\nReps: 12-15\nSeated Rows (Machine or Cable)\nReps: 12-15\nPlank to Push-Up\nReps: 8-10\nCool Down (10 min)\nStatic stretches focusing on the muscles worked.', 
    'Cardio Intervals\nWarm-Up (10 min)\nDynamic stretches: High knees, butt kicks, and arm swings.\nInterval Training (30-40 min)\nChoose one of the following options and perform:\nRunning\nFormat: 1 min sprint, 2 min walk/jog; repeat for 20-30 min.\nCycling\nFormat: 1 min high intensity, 2 min low intensity; repeat for 30 min.\nRowing Machine\nFormat: 30 sec sprint, 1 min easy; repeat for 20-30 min.\nCool Down (10 min)\nStatic stretches focusing on legs and core.', 
    'Long Steady-State Cardio\nWarm-Up (10 min)\nDynamic stretches: Light jogging and mobility exercises.\nSteady-State Cardio (45-60 min)\nChoose one of the following options:\nRunning or Jogging\nMaintain a steady pace for 45-60 min.\nCycling\nRide at a steady pace for 45-60 min.\nSwimming\nSwim continuously for 30-45 min.\nCool Down (10 min)\nStatic stretches focusing on legs and shoulders.', 
    'Full Body Circuit\nWarm-Up (10 min)\nDynamic stretches: Leg swings, torso twists, and light jogging.\nFull Body Circuit (40 min)\nPerform 3 sets of the following exercises with moderate weights:\nKettlebell Swings\nReps: 15-20\nBurpees\nReps: 10-12\nMedicine Ball Slams\nReps: 10-15\nBox Jumps\nReps: 10-12\nBattle Ropes (if available)\nDuration: 30-45 sec\nCore Finisher (10 min)\nPerform 2 rounds of the following:\nRussian Twists\nReps: 15 per side\nBicycle Crunches\nReps: 12-15 per side\nPlank\nDuration: 30-60 sec\nCool Down (10 min)\nStatic stretches focusing on overall flexibility.'
);


--  26th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises
) 
VALUES (
    '31-45', 'Improve Endurance', 5, 'Intermediate', 
    'Endurance Strength Training\nWarm-Up (10 min)\nDynamic stretches: Arm circles, leg swings, and light cardio (jogging or jump rope).\nEndurance Strength Circuit (40 min)\nPerform 3-4 sets of the following exercises with lighter weights and higher reps:\nBarbell Squats\nReps: 12-15\nPush-Ups (Regular or Knee)\nReps: 10-15\nDumbbell Deadlifts\nReps: 12-15\nStanding Dumbbell Shoulder Press\nReps: 12-15\nSeated Rows (Machine or Cable)\nReps: 12-15\nPlank to Push-Up\nReps: 8-10\nCool Down (10 min)\nStatic stretches focusing on the muscles worked.', 
    'Cardio Intervals\nWarm-Up (10 min)\nDynamic stretches: High knees, butt kicks, and arm swings.\nInterval Training (30-40 min)\nChoose one of the following options and perform:\nRunning\nFormat: 1 min sprint, 2 min walk/jog; repeat for 20-30 min.\nCycling\nFormat: 1 min high intensity, 2 min low intensity; repeat for 30 min.\nRowing Machine\nFormat: 30 sec sprint, 1 min easy; repeat for 20-30 min.\nCool Down (10 min)\nStatic stretches focusing on legs and core.', 
    'Full Body Circuit\nWarm-Up (10 min)\nDynamic stretches: Leg swings, torso twists, and light jogging.\nFull Body Circuit (40 min)\nPerform 3-4 sets of the following exercises with moderate weights:\nKettlebell Swings\nReps: 15-20\nBurpees\nReps: 10-12\nMedicine Ball Slams\nReps: 10-15\nBox Jumps\nReps: 10-12\nBattle Ropes (if available)\nDuration: 30-45 sec\nCore Finisher (10 min)\nPerform 2 rounds of the following:\nRussian Twists\nReps: 15 per side\nBicycle Crunches\nReps: 12-15 per side\nPlank\nDuration: 30-60 sec\nCool Down (10 min)\nStatic stretches focusing on overall flexibility.', 
    'Long Steady-State Cardio\nWarm-Up (10 min)\nDynamic stretches: Light jogging and mobility exercises.\nSteady-State Cardio (45-60 min)\nChoose one of the following options:\nRunning or Jogging\nMaintain a steady pace for 45-60 min.\nCycling\nRide at a steady pace for 45-60 min.\nSwimming\nSwim continuously for 30-45 min.\nCool Down (10 min)\nStatic stretches focusing on legs and shoulders.', 
    'Active Recovery\nLight Activity (30-40 min)\nEngage in low-impact activities such as walking, yoga, or cycling at a comfortable pace.\nMobility and Flexibility (20 min)\nPerform a yoga routine or dynamic stretching to enhance flexibility and recovery.\nCool Down (10 min)\nStatic stretches focusing on any tight areas.'
);


--  27th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises, day6_exercises
) 
VALUES (
    '31-45', 'Improve Endurance', 6, 'Intermediate', 
    'Endurance Strength Training\nWarm-Up (10 min)\nDynamic stretches: Arm circles, leg swings, and light cardio (jogging or jump rope).\nEndurance Strength Circuit (40 min)\nPerform 3-4 sets of the following exercises with lighter weights and higher reps:\nBarbell Squats\nReps: 12-15\nPush-Ups (Regular or Knee)\nReps: 10-15\nDumbbell Deadlifts\nReps: 12-15\nStanding Dumbbell Shoulder Press\nReps: 12-15\nSeated Rows (Machine or Cable)\nReps: 12-15\nPlank to Push-Up\nReps: 8-10\nCool Down (10 min)\nStatic stretches focusing on the muscles worked.', 
    'Cardio Intervals\nWarm-Up (10 min)\nDynamic stretches: High knees, butt kicks, and arm swings.\nInterval Training (30-40 min)\nChoose one of the following options and perform:\nRunning\nFormat: 1 min sprint, 2 min walk/jog; repeat for 20-30 min.\nCycling\nFormat: 1 min high intensity, 2 min low intensity; repeat for 30 min.\nRowing Machine\nFormat: 30 sec sprint, 1 min easy; repeat for 20-30 min.\nCool Down (10 min)\nStatic stretches focusing on legs and core.', 
    'Full Body Circuit\nWarm-Up (10 min)\nDynamic stretches: Leg swings, torso twists, and light jogging.\nFull Body Circuit (40 min)\nPerform 3-4 sets of the following exercises with moderate weights:\nKettlebell Swings\nReps: 15-20\nBurpees\nReps: 10-12\nMedicine Ball Slams\nReps: 10-15\nBox Jumps\nReps: 10-12\nBattle Ropes (if available)\nDuration: 30-45 sec\nCore Finisher (10 min)\nPerform 2 rounds of the following:\nRussian Twists\nReps: 15 per side\nBicycle Crunches\nReps: 12-15 per side\nPlank\nDuration: 30-60 sec\nCool Down (10 min)\nStatic stretches focusing on overall flexibility.', 
    'Long Steady-State Cardio\nWarm-Up (10 min)\nDynamic stretches: Light jogging and mobility exercises.\nSteady-State Cardio (45-60 min)\nChoose one of the following options:\nRunning or Jogging\nMaintain a steady pace for 45-60 min.\nCycling\nRide at a steady pace for 45-60 min.\nSwimming\nSwim continuously for 30-45 min.\nCool Down (10 min)\nStatic stretches focusing on legs and shoulders.', 
    'Speed and Agility Work\nWarm-Up (10 min)\nDynamic stretches: Skipping, high knees, and mobility drills.\nSpeed and Agility Drills (30-40 min)\nPerform 3-4 sets of the following:\nCone Drills (Shuttle runs or T-drills)\nDuration: 30-60 sec\nLateral Bounds\nReps: 10-12 per side\nAgility Ladder Drills (various patterns)\nDuration: 10-15 min\nSprint Intervals\n30 sec sprint followed by 1 min walk; repeat 5-8 times.\nCool Down (10 min)\nStatic stretches focusing on legs and hips.', 
    'Active Recovery\nLight Activity (30-40 min)\nEngage in low-impact activities such as walking, yoga, or cycling at a comfortable pace.\nMobility and Flexibility (20 min)\nPerform a yoga routine or dynamic stretching to enhance flexibility and recovery.\nCool Down (10 min)\nStatic stretches focusing on any tight areas.'
);

--  28th data 
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises
) 
VALUES (
    '31-45', 'Enhanced Flexibility', 4, 'Intermediate', 
    'Full Body Flexibility Routine\nWarm-Up (10 min)\nDynamic stretches: Arm circles, leg swings, and light cardio (jogging or brisk walking).\nFull Body Stretching Routine (40 min)\nHold each stretch for 20-30 seconds, and repeat 2-3 times:\nStanding Forward Bend\nCat-Cow Stretch\nStanding Quadriceps Stretch\nSeated Hamstring Stretch\nChild’s Pose\nPigeon Pose\nLunge with a Twist\nCobra Pose\nCool Down (10 min)\nGentle stretches focusing on relaxation and breath.', 
    'Dynamic Stretching and Mobility\nWarm-Up (10 min)\nLight cardio: Jumping jacks or brisk walking for 5 min, followed by dynamic stretching.\nDynamic Stretching Routine (30-40 min)\nPerform each dynamic stretch for 30 seconds:\nLeg Swings (Front to Back)\nArm Crossovers\nTorso Twists\nHip Circles\nWalking Lunges with a Twist\nKnee Hugs\nToy Soldiers\nInchworms\nMobility Drills (10-15 min)\nDeep Squat Hold\nDuration: 30-60 sec\nAnkle Mobility\nDuration: 30-60 sec per side\nShoulder Pass-Throughs with a Band\nReps: 10-12\nCool Down (10 min)\nStatic stretches focusing on any tight areas.', 
    'Active Recovery and Yoga\nYoga Session (45-60 min)\nFocus on flexibility-enhancing poses, such as:\nDownward Dog\nWarrior II\nTriangle Pose\nBridge Pose\nSeated Forward Bend\nHappy Baby\nReclining Bound Angle Pose\nSavasana (Corpse Pose) for relaxation.\nCool Down (10 min)\nGentle stretching and breathwork.', 
    'Flexibility Circuit\nWarm-Up (10 min)\nDynamic stretches: Light jogging, high knees, and butt kicks.\nFlexibility Circuit (40 min)\nPerform each exercise for 30 seconds, followed by 15-30 seconds of rest:\nStanding Calf Stretch\nWall Shoulder Stretch\nSeated Butterfly Stretch\nLying Quad Stretch\nForearm Stretch (Wrist Flexor and Extensor)\nFigure Four Stretch\nSpinal Twist\nSide Lunge Stretch\nCool Down (10 min)\nStatic stretches focusing on overall flexibility.'
);


--  29th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises
) 
VALUES (
    '31-45', 'Enhanced Flexibility', 5, 'Intermediate', 
    'Full Body Flexibility Routine\nWarm-Up (10 min)\nDynamic stretches: Arm circles, leg swings, and light jogging.\nFull Body Stretching Routine (40 min)\nHold each stretch for 20-30 seconds, and repeat 2-3 times:\nStanding Forward Bend\nCat-Cow Stretch\nStanding Quadriceps Stretch\nSeated Hamstring Stretch\nChild’s Pose\nPigeon Pose\nLunge with a Twist\nCobra Pose\nCool Down (10 min)\nGentle stretches focusing on relaxation and breath.', 
    'Dynamic Stretching and Mobility\nWarm-Up (10 min)\nLight cardio: Jumping jacks or brisk walking for 5 min, followed by dynamic stretching.\nDynamic Stretching Routine (30-40 min)\nPerform each dynamic stretch for 30 seconds:\nLeg Swings (Front to Back)\nArm Crossovers\nTorso Twists\nHip Circles\nWalking Lunges with a Twist\nKnee Hugs\nToy Soldiers\nInchworms\nMobility Drills (10-15 min)\nDeep Squat Hold\nDuration: 30-60 sec\nAnkle Mobility\nDuration: 30-60 sec per side\nShoulder Pass-Throughs with a Band\nReps: 10-12\nCool Down (10 min)\nStatic stretches focusing on any tight areas.', 
    'Yoga for Flexibility\nYoga Session (45-60 min)\nFocus on flexibility-enhancing poses, such as:\nDownward Dog\nWarrior I & II\nTriangle Pose\nBridge Pose\nSeated Forward Bend\nHappy Baby\nLizard Pose\nSavasana (Corpse Pose) for relaxation.\nCool Down (10 min)\nGentle stretching and breathwork.', 
    'Flexibility Circuit Training\nWarm-Up (10 min)\nDynamic stretches: Light jogging, high knees, and butt kicks.\nFlexibility Circuit (40 min)\nPerform each exercise for 30 seconds, followed by 15-30 seconds of rest:\nStanding Calf Stretch\nWall Shoulder Stretch\nSeated Butterfly Stretch\nLying Quad Stretch\nForearm Stretch (Wrist Flexor and Extensor)\nFigure Four Stretch\nSpinal Twist\nSide Lunge Stretch\nCore Finisher (10 min)\nPerform 2 rounds of the following:\nBird-Dog\nReps: 10-12 per side\nPlank to Side Plank\nDuration: 30-60 sec\nCool Down (10 min)\nStatic stretches focusing on overall flexibility.', 
    'Active Recovery\nLight Activity (30-40 min)\nEngage in low-impact activities such as walking, swimming, or gentle cycling.\nMobility and Flexibility (20 min)\nPerform a yoga routine or gentle stretching to enhance flexibility and recovery.\nCool Down (10 min)'
);


--  30th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises, day6_exercises
) 
VALUES (
    '31-45', 'Enhanced Flexibility', 6, 'Intermediate', 
    'Full Body Flexibility Routine\nWarm-Up (10 min)\nDynamic stretches: Arm circles, leg swings, and light jogging.\nFull Body Stretching Routine (40 min)\nHold each stretch for 20-30 seconds, and repeat 2-3 times:\nStanding Forward Bend\nCat-Cow Stretch\nStanding Quadriceps Stretch\nSeated Hamstring Stretch\nChild’s Pose\nPigeon Pose\nLunge with a Twist\nCobra Pose\nCool Down (10 min)\nGentle stretches focusing on relaxation and breath.', 
    'Dynamic Stretching and Mobility\nWarm-Up (10 min)\nLight cardio: Jumping jacks or brisk walking for 5 min, followed by dynamic stretching.\nDynamic Stretching Routine (30-40 min)\nPerform each dynamic stretch for 30 seconds:\nLeg Swings (Front to Back)\nArm Crossovers\nTorso Twists\nHip Circles\nWalking Lunges with a Twist\nKnee Hugs\nToy Soldiers\nInchworms\nMobility Drills (10-15 min)\nDeep Squat Hold\nDuration: 30-60 sec\nAnkle Mobility\nDuration: 30-60 sec per side\nShoulder Pass-Throughs with a Band\nReps: 10-12\nCool Down (10 min)\nStatic stretches focusing on any tight areas.', 
    'Yoga for Flexibility\nYoga Session (45-60 min)\nFocus on flexibility-enhancing poses, such as:\nDownward Dog\nWarrior I & II\nTriangle Pose\nBridge Pose\nSeated Forward Bend\nHappy Baby\nLizard Pose\nSavasana (Corpse Pose) for relaxation.\nCool Down (10 min)\nGentle stretching and breathwork.', 
    'Flexibility Circuit Training\nWarm-Up (10 min)\nDynamic stretches: Light jogging, high knees, and butt kicks.\nFlexibility Circuit (40 min)\nPerform each exercise for 30 seconds, followed by 15-30 seconds of rest:\nStanding Calf Stretch\nWall Shoulder Stretch\nSeated Butterfly Stretch\nLying Quad Stretch\nForearm Stretch (Wrist Flexor and Extensor)\nFigure Four Stretch\nSpinal Twist\nSide Lunge Stretch\nCore Finisher (10 min)\nPerform 2 rounds of the following:\nBird-Dog\nReps: 10-12 per side\nPlank to Side Plank\nDuration: 30-60 sec\nCool Down (10 min)\nStatic stretches focusing on overall flexibility.', 
    'Active Recovery and Mobility\nLight Activity (30-40 min)\nEngage in low-impact activities such as walking, swimming, or gentle cycling.\nMobility and Flexibility (20 min)\nPerform a yoga routine or gentle stretching to enhance flexibility and recovery.\nCool Down (10 min)\nStatic stretches focusing on any tight areas.', 
    'Deep Stretching and Relaxation\nWarm-Up (10 min)\nGentle movements: Slow arm swings, neck rotations, and light cardio.\nDeep Stretching Routine (45-60 min)\nHold each stretch for 30-60 seconds, and repeat 2-3 times:\nSeated Forward Bend\nButterfly Stretch\nHip Flexor Stretch\nPigeon Pose\nUpper Back Stretch\nChild’s Pose\nCobra Pose\nSupine Spinal Twist\nRelaxation Techniques (10 min)\nPractice deep breathing or meditation while holding stretches.'
);


--  31st data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises
) 
VALUES (
    '16-30', 'Weight Loss', 4, 'Intermediate', 
    'Full Body Strength Training\nWarm-Up (10 min)\nDynamic stretches: Arm circles, leg swings, and light jogging.\nFull Body Strength Routine (40 min)\nPerform 3 sets of 10-12 reps for each exercise:\nBarbell Squats\nDumbbell Bench Press\nBent Over Rows (Dumbbell or Barbell)\nDeadlifts (Dumbbell or Barbell)\nPlank with Shoulder Taps\nDumbbell Shoulder Press\nCool Down (10 min)\nGentle stretching focusing on major muscle groups.', 
    'High-Intensity Interval Training (HIIT)\nWarm-Up (10 min)\nLight cardio: Jumping jacks, high knees, and dynamic stretches.\nHIIT Workout (20-30 min)\nPerform each exercise for 30 seconds, followed by 30 seconds of rest. Repeat the circuit 3-4 times:\nBurpees\nMountain Climbers\nSquat Jumps\nPush-Ups\nHigh Knees\nPlank Jacks\nCool Down (10 min)\nStatic stretches focusing on overall body relaxation.', 
    'Active Recovery and Core\nActive Recovery (30 min)\nEngage in low-impact activities such as brisk walking, cycling, or swimming.\nCore Workout (20-30 min)\nPerform 3 sets of the following:\nPlank\nDuration: 30-60 sec\nRussian Twists\nReps: 15-20 per side\nBicycle Crunches\nReps: 15-20 per side\nLeg Raises\nReps: 10-15\nSide Plank\nDuration: 20-30 sec per side\nCool Down (10 min)\nGentle stretches focusing on the core and back.', 
    'Circuit Training\nWarm-Up (10 min)\nDynamic stretches: Light jogging, arm swings, and leg swings.\nCircuit Workout (40 min)\nPerform each exercise for 45 seconds, followed by 15 seconds of rest. Repeat the circuit 2-3 times:\nJump Rope\nKettlebell Swings\nDumbbell Thrusters\nWalking Lunges\nBox Jumps (or Step-Ups)\nTricep Dips\nCool Down (10 min)\nStatic stretches focusing on the entire body.'
);


--  32nd data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises
) 
VALUES (
    '16-30', 'Weight Loss', 5, 'Intermediate', 
    'Full Body Strength Training\nWarm-Up (10 min)\nDynamic stretches: Arm circles, leg swings, and light jogging.\nFull Body Strength Routine (40 min)\nPerform 3 sets of 10-12 reps for each exercise:\nBarbell Squats\nDumbbell Bench Press\nBent Over Rows (Dumbbell or Barbell)\nDeadlifts (Dumbbell or Barbell)\nPlank with Shoulder Taps\nDumbbell Shoulder Press\nCool Down (10 min)\nGentle stretching focusing on major muscle groups.', 
    'High-Intensity Interval Training (HIIT)\nWarm-Up (10 min)\nLight cardio: Jumping jacks, high knees, and dynamic stretches.\nHIIT Workout (20-30 min)\nPerform each exercise for 30 seconds, followed by 30 seconds of rest. Repeat the circuit 3-4 times:\nBurpees\nMountain Climbers\nSquat Jumps\nPush-Ups\nHigh Knees\nPlank Jacks\nCool Down (10 min)\nStatic stretches focusing on overall body relaxation.', 
    'Core and Cardio\nWarm-Up (10 min)\nDynamic stretches: Light jogging, arm swings, and leg swings.\nCardio Routine (20-30 min)\nChoose one:\nRunning or Jogging: Maintain a steady pace.\nCycling: Moderate intensity.\nJump Rope: Continuous for 20-30 minutes.\nCore Workout (20-30 min)\nPerform 3 sets of the following:\nPlank\nDuration: 30-60 sec\nRussian Twists\nReps: 15-20 per side\nBicycle Crunches\nReps: 15-20 per side\nLeg Raises\nReps: 10-15\nSide Plank\nDuration: 20-30 sec per side\nCool Down (10 min)\nGentle stretches focusing on the core and back.', 
    'Circuit Training\nWarm-Up (10 min)\nDynamic stretches: Light jogging, arm swings, and leg swings.\nCircuit Workout (40 min)\nPerform each exercise for 45 seconds, followed by 15 seconds of rest. Repeat the circuit 2-3 times:\nJump Rope\nKettlebell Swings\nDumbbell Thrusters\nWalking Lunges\nBox Jumps (or Step-Ups)\nTricep Dips\nCool Down (10 min)\nStatic stretches focusing on the entire body.', 
    'Active Recovery and Flexibility\nActive Recovery (30 min)\nEngage in low-impact activities such as brisk walking, cycling, or swimming.\nFlexibility Routine (20-30 min)\nHold each stretch for 20-30 seconds, and repeat 2-3 times:\nStanding Forward Bend\nCat-Cow Stretch\nSeated Hamstring Stretch\nChild’s Pose\nCobra Pose\nPigeon Pose\nLunge with a Twist\nCool Down (10 min)\nStatic stretches focusing on overall relaxation.'
);


--  33rd data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises, day6_exercises
) 
VALUES (
    '16-30', 'Weight Loss', 6, 'Intermediate', 
    'Full Body Strength Training\nWarm-Up (10 min)\nDynamic stretches: Arm circles, leg swings, and light jogging.\nFull Body Strength Routine (40 min)\nPerform 3 sets of 10-12 reps for each exercise:\nBarbell Squats\nDumbbell Bench Press\nBent Over Rows (Dumbbell or Barbell)\nDeadlifts (Dumbbell or Barbell)\nPlank with Shoulder Taps\nDumbbell Shoulder Press\nCool Down (10 min)\nGentle stretching focusing on major muscle groups.', 
    'High-Intensity Interval Training (HIIT)\nWarm-Up (10 min)\nLight cardio: Jumping jacks, high knees, and dynamic stretches.\nHIIT Workout (20-30 min)\nPerform each exercise for 30 seconds, followed by 30 seconds of rest. Repeat the circuit 3-4 times:\nBurpees\nMountain Climbers\nSquat Jumps\nPush-Ups\nHigh Knees\nPlank Jacks\nCool Down (10 min)\nStatic stretches focusing on overall body relaxation.', 
    'Core and Cardio\nWarm-Up (10 min)\nDynamic stretches: Light jogging, arm swings, and leg swings.\nCardio Routine (20-30 min)\nChoose one:\nRunning or Jogging: Maintain a steady pace.\nCycling: Moderate intensity.\nJump Rope: Continuous for 20-30 minutes.\nCore Workout (20-30 min)\nPerform 3 sets of the following:\nPlank\nDuration: 30-60 sec\nRussian Twists\nReps: 15-20 per side\nBicycle Crunches\nReps: 15-20 per side\nLeg Raises\nReps: 10-15\nSide Plank\nDuration: 20-30 sec per side\nCool Down (10 min)\nGentle stretches focusing on the core and back.', 
    'Circuit Training\nWarm-Up (10 min)\nDynamic stretches: Light jogging, arm swings, and leg swings.\nCircuit Workout (40 min)\nPerform each exercise for 45 seconds, followed by 15 seconds of rest. Repeat the circuit 2-3 times:\nJump Rope\nKettlebell Swings\nDumbbell Thrusters\nWalking Lunges\nBox Jumps (or Step-Ups)\nTricep Dips\nCool Down (10 min)\nStatic stretches focusing on the entire body.', 
    'Active Recovery and Flexibility\nActive Recovery (30 min)\nEngage in low-impact activities such as brisk walking, cycling, or swimming.\nFlexibility Routine (20-30 min)\nHold each stretch for 20-30 seconds, and repeat 2-3 times:\nStanding Forward Bend\nCat-Cow Stretch\nSeated Hamstring Stretch\nChild’s Pose\nCobra Pose\nPigeon Pose\nLunge with a Twist\nCool Down (10 min)\nStatic stretches focusing on overall relaxation.', 
    'Strength Training (Upper Body Focus)\nWarm-Up (10 min)\nDynamic stretches: Arm swings, shoulder rolls, and light cardio.\nUpper Body Strength Routine (40 min)\nPerform 3 sets of 10-12 reps for each exercise:\nPush-Ups (Weighted if possible)\nDumbbell Bench Press\nBent Over Dumbbell Flyes\nSeated Cable Rows\nOverhead Dumbbell Press\nTricep Kickbacks\nCool Down (10 min)\nGentle stretching focusing on the arms, shoulders, and chest.'
);



--  34th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises
) 
VALUES (
    '16-30', 'Muscle Gain', 4, 'Intermediate', 
    'Upper Body (Push)\nWarm-Up (10 min)\nDynamic stretches: Arm circles, chest openers, and light jogging.\nUpper Body Push Routine (40 min)\nPerform 3-4 sets of 8-12 reps for each exercise:\nBarbell Bench Press\nIncline Dumbbell Press\nDumbbell Shoulder Press\nLateral Raises\nTricep Dips (Weighted if possible)\nOverhead Tricep Extension (Dumbbell or EZ Bar)\nCool Down (10 min)\nGentle stretching focusing on chest, shoulders, and triceps.', 
    'Lower Body\nWarm-Up (10 min)\nDynamic stretches: Leg swings, hip circles, and light jogging.\nLower Body Routine (40 min)\nPerform 3-4 sets of 8-12 reps for each exercise:\nBarbell Squats\nRomanian Deadlifts\nLeg Press\nWalking Lunges (Dumbbell or Barbell)\nCalf Raises (Standing)\nLeg Curls (Machine)\nCool Down (10 min)\nGentle stretching focusing on quadriceps, hamstrings, and calves.', 
    'Upper Body (Pull)\nWarm-Up (10 min)\nDynamic stretches: Arm swings, torso twists, and light jogging.\nUpper Body Pull Routine (40 min)\nPerform 3-4 sets of 8-12 reps for each exercise:\nPull-Ups (Assisted if necessary)\nBent Over Barbell Rows\nSeated Cable Rows\nFace Pulls\nBarbell Bicep Curls\nHammer Curls\nCool Down (10 min)\nGentle stretching focusing on back, biceps, and shoulders.', 
    'Legs & Core\nWarm-Up (10 min)\nDynamic stretches: Leg swings, hip openers, and light jogging.\nLegs & Core Routine (40 min)\nPerform 3-4 sets of 8-12 reps for each exercise:\nDeadlifts (Conventional or Sumo)\nBulgarian Split Squats\nLeg Extensions (Machine)\nSeated Calf Raises\nPlank\nDuration: 30-60 sec\nHanging Leg Raises or Crunches\nReps: 10-15\nCool Down (10 min)\nGentle stretching focusing on legs and core.'
);


--  35th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises
) 
VALUES (
    '16-30', 'Muscle Gain', 5, 'Intermediate', 
    'Upper Body (Push)\nWarm-Up (10 min)\nDynamic stretches: Arm circles, chest openers, and light jogging.\nUpper Body Push Routine (40 min)\nPerform 3-4 sets of 8-12 reps for each exercise:\nBarbell Bench Press\nIncline Dumbbell Press\nDumbbell Shoulder Press\nLateral Raises\nTricep Dips (Weighted if possible)\nOverhead Tricep Extension (Dumbbell or EZ Bar)\nCool Down (10 min)\nGentle stretching focusing on chest, shoulders, and triceps.', 
    'Lower Body\nWarm-Up (10 min)\nDynamic stretches: Leg swings, hip circles, and light jogging.\nLower Body Routine (40 min)\nPerform 3-4 sets of 8-12 reps for each exercise:\nBarbell Squats\nRomanian Deadlifts\nLeg Press\nWalking Lunges (Dumbbell or Barbell)\nCalf Raises (Standing)\nLeg Curls (Machine)\nCool Down (10 min)\nGentle stretching focusing on quadriceps, hamstrings, and calves.', 
    'Upper Body (Pull)\nWarm-Up (10 min)\nDynamic stretches: Arm swings, torso twists, and light jogging.\nUpper Body Pull Routine (40 min)\nPerform 3-4 sets of 8-12 reps for each exercise:\nPull-Ups (Assisted if necessary)\nBent Over Barbell Rows\nSeated Cable Rows\nFace Pulls\nBarbell Bicep Curls\nHammer Curls\nCool Down (10 min)\nGentle stretching focusing on back, biceps, and shoulders.', 
    'Legs & Core\nWarm-Up (10 min)\nDynamic stretches: Leg swings, hip openers, and light jogging.\nLegs & Core Routine (40 min)\nPerform 3-4 sets of 8-12 reps for each exercise:\nDeadlifts (Conventional or Sumo)\nBulgarian Split Squats\nLeg Extensions (Machine)\nSeated Calf Raises\nPlank\nDuration: 30-60 sec\nHanging Leg Raises or Cable Crunches\nReps: 10-15\nCool Down (10 min)\nGentle stretching focusing on legs and core.',
    'Full Body\nWarm-Up (10 min)\nDynamic stretches: Light jogging, arm swings, and leg swings.\nFull Body Routine (40 min)\nPerform 3 sets of 10-12 reps for each exercise:\nClean and Press\nKettlebell Swings\nPush-Ups (Weighted if possible)\nDumbbell Step-Ups\nBattle Ropes (if available)\nDuration: 30-45 sec\nRussian Twists\nReps: 15-20 per side\nCool Down (10 min)\nGentle stretching focusing on overall body relaxation.'
);


--  36th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises, day6_exercises
) 
VALUES (
    '16-30', 'Muscle Gain', 6, 'Intermediate', 
    'Upper Body (Push)\nWarm-Up (10 min)\nDynamic stretches: Arm circles, chest openers, and light jogging.\nUpper Body Push Routine (40 min)\nPerform 3-4 sets of 8-12 reps for each exercise:\nBarbell Bench Press\nIncline Dumbbell Press\nDumbbell Shoulder Press\nLateral Raises\nTricep Dips (Weighted if possible)\nOverhead Tricep Extension (Dumbbell or EZ Bar)\nCool Down (10 min)\nGentle stretching focusing on chest, shoulders, and triceps.', 
    'Lower Body\nWarm-Up (10 min)\nDynamic stretches: Leg swings, hip circles, and light jogging.\nLower Body Routine (40 min)\nPerform 3-4 sets of 8-12 reps for each exercise:\nBarbell Squats\nRomanian Deadlifts\nLeg Press\nWalking Lunges (Dumbbell or Barbell)\nCalf Raises (Standing)\nLeg Curls (Machine)\nCool Down (10 min)\nGentle stretching focusing on quadriceps, hamstrings, and calves.', 
    'Upper Body (Pull)\nWarm-Up (10 min)\nDynamic stretches: Arm swings, torso twists, and light jogging.\nUpper Body Pull Routine (40 min)\nPerform 3-4 sets of 8-12 reps for each exercise:\nPull-Ups (Assisted if necessary)\nBent Over Barbell Rows\nSeated Cable Rows\nFace Pulls\nBarbell Bicep Curls\nHammer Curls\nCool Down (10 min)\nGentle stretching focusing on back, biceps, and shoulders.', 
    'Legs & Core\nWarm-Up (10 min)\nDynamic stretches: Leg swings, hip openers, and light jogging.\nLegs & Core Routine (40 min)\nPerform 3-4 sets of 8-12 reps for each exercise:\nDeadlifts (Conventional or Sumo)\nBulgarian Split Squats\nLeg Extensions (Machine)\nSeated Calf Raises\nPlank\nDuration: 30-60 sec\nHanging Leg Raises or Cable Crunches\nReps: 10-15\nCool Down (10 min)\nGentle stretching focusing on legs and core.',
    'Upper Body (Push)\nWarm-Up (10 min)\nDynamic stretches: Arm circles, chest openers, and light jogging.\nUpper Body Push Routine (40 min)\nPerform 3-4 sets of 8-12 reps for each exercise:\nIncline Barbell Bench Press\nDumbbell Flyes\nArnold Press\nFront Raises\nSkull Crushers\nTricep Kickbacks\nCool Down (10 min)\nGentle stretching focusing on chest, shoulders, and triceps.',
    'Lower Body\nWarm-Up (10 min)\nDynamic stretches: Leg swings, hip circles, and light jogging.\nLower Body Routine (40 min)\nPerform 3-4 sets of 8-12 reps for each exercise:\nFront Squats\nDeadlifts (Romanian)\nLeg Press\nDumbbell Lunges\nCalf Raises (Seated)\nHip Thrusts\nCool Down (10 min)\nGentle stretching focusing on quadriceps, hamstrings, and calves.'
);


--  37th data 
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises
) 
VALUES (
    '16-30', 'General Workout', 4, 'Intermediate', 
    'Upper Body\nWarm-Up (10 min)\nDynamic stretches: Arm circles, torso twists, and light jogging.\nUpper Body Routine (40 min)\nPerform 3 sets of 10-12 reps for each exercise:\nBarbell Bench Press\nDumbbell Shoulder Press\nPull-Ups (Assisted if necessary)\nBent Over Dumbbell Rows\nLateral Raises\nTricep Dips\nCool Down (10 min)\nGentle stretching focusing on chest, shoulders, and triceps.', 
    'Lower Body\nWarm-Up (10 min)\nDynamic stretches: Leg swings, hip openers, and light jogging.\nLower Body Routine (40 min)\nPerform 3 sets of 10-12 reps for each exercise:\nBarbell Squats\nRomanian Deadlifts\nLeg Press\nWalking Lunges (Dumbbell or Barbell)\nCalf Raises (Standing)\nLeg Curls (Machine)\nCool Down (10 min)\nGentle stretching focusing on quadriceps, hamstrings, and calves.', 
    'Full Body\nWarm-Up (10 min)\nDynamic stretches: Light jogging, arm swings, and leg swings.\nFull Body Routine (40 min)\nPerform 3 sets of 10-12 reps for each exercise:\nClean and Press\nKettlebell Swings\nPush-Ups\nDumbbell Step-Ups\nBattle Ropes (if available)\nDuration: 30-45 sec\nRussian Twists\nReps: 15-20 per side\nCool Down (10 min)\nGentle stretching focusing on overall body relaxation.', 
    'Core & Cardio\nWarm-Up (10 min)\nDynamic stretches: Light jogging and torso twists.\nCore & Cardio Routine (40 min)\nPerform 3 sets of the following:\nPlank\nDuration: 30-60 sec\nBicycle Crunches\nReps: 15-20 per side\nHanging Leg Raises or Mountain Climbers\nReps: 10-15\nBurpees\nReps: 8-10\nJump Rope or High Knees\nDuration: 1 min\nCool Down (10 min)\nGentle stretching focusing on core and lower back.'
);


--  38th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises
) 
VALUES (
    '16-30', 'General Workout', 5, 'Intermediate', 
    'Upper Body\nWarm-Up (10 min)\nDynamic stretches: Arm circles, torso twists, and light jogging.\nUpper Body Routine (40 min)\nPerform 3 sets of 10-12 reps for each exercise:\nBarbell Bench Press\nDumbbell Shoulder Press\nPull-Ups (Assisted if necessary)\nBent Over Dumbbell Rows\nLateral Raises\nTricep Dips\nCool Down (10 min)\nGentle stretching focusing on chest, shoulders, and triceps.', 
    'Lower Body\nWarm-Up (10 min)\nDynamic stretches: Leg swings, hip openers, and light jogging.\nLower Body Routine (40 min)\nPerform 3 sets of 10-12 reps for each exercise:\nBarbell Squats\nRomanian Deadlifts\nLeg Press\nWalking Lunges (Dumbbell or Barbell)\nCalf Raises (Standing)\nLeg Curls (Machine)\nCool Down (10 min)\nGentle stretching focusing on quadriceps, hamstrings, and calves.', 
    'Full Body\nWarm-Up (10 min)\nDynamic stretches: Light jogging, arm swings, and leg swings.\nFull Body Routine (40 min)\nPerform 3 sets of 10-12 reps for each exercise:\nClean and Press\nKettlebell Swings\nPush-Ups\nDumbbell Step-Ups\nBattle Ropes (if available)\nDuration: 30-45 sec\nRussian Twists\nReps: 15-20 per side\nCool Down (10 min)\nGentle stretching focusing on overall body relaxation.', 
    'Core & Cardio\nWarm-Up (10 min)\nDynamic stretches: Light jogging and torso twists.\nCore & Cardio Routine (40 min)\nPerform 3 sets of the following:\nPlank\nDuration: 30-60 sec\nBicycle Crunches\nReps: 15-20 per side\nHanging Leg Raises or Mountain Climbers\nReps: 10-15\nBurpees\nReps: 8-10\nJump Rope or High Knees\nDuration: 1 min\nCool Down (10 min)\nGentle stretching focusing on core and lower back.',
    'Upper Body\nWarm-Up (10 min)\nDynamic stretches: Arm swings, chest openers, and light jogging.\nUpper Body Routine (40 min)\nPerform 3 sets of 10-12 reps for each exercise:\nIncline Barbell Bench Press\nDumbbell Flyes\nSeated Cable Rows\nDumbbell Shoulder Press\nSkull Crushers\nDumbbell Lateral Raises\nCool Down (10 min)\nGentle stretching focusing on chest, shoulders, and triceps.'
);


--  39th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, 
    day4_exercises, day5_exercises, day6_exercises
) 
VALUES (
    '16-30', 'General Workout', 6, 'Intermediate', 
    'Upper Body\nWarm-Up (10 min)\nDynamic stretches: Arm circles, torso twists, and light jogging.\nUpper Body Routine (40 min)\nPerform 3 sets of 10-12 reps for each exercise:\nBarbell Bench Press\nDumbbell Shoulder Press\nPull-Ups (Assisted if necessary)\nBent Over Dumbbell Rows\nLateral Raises\nTricep Dips\nCool Down (10 min)\nGentle stretching focusing on chest, shoulders, and triceps.', 
    'Lower Body\nWarm-Up (10 min)\nDynamic stretches: Leg swings, hip openers, and light jogging.\nLower Body Routine (40 min)\nPerform 3 sets of 10-12 reps for each exercise:\nBarbell Squats\nRomanian Deadlifts\nLeg Press\nWalking Lunges (Dumbbell or Barbell)\nCalf Raises (Standing)\nLeg Curls (Machine)\nCool Down (10 min)\nGentle stretching focusing on quadriceps, hamstrings, and calves.', 
    'Full Body\nWarm-Up (10 min)\nDynamic stretches: Light jogging, arm swings, and leg swings.\nFull Body Routine (40 min)\nPerform 3 sets of 10-12 reps for each exercise:\nClean and Press\nKettlebell Swings\nPush-Ups\nDumbbell Step-Ups\nBattle Ropes (if available)\nDuration: 30-45 sec\nRussian Twists\nReps: 15-20 per side\nCool Down (10 min)\nGentle stretching focusing on overall body relaxation.', 
    'Upper Body\nWarm-Up (10 min)\nDynamic stretches: Arm swings, chest openers, and light jogging.\nUpper Body Routine (40 min)\nPerform 3 sets of 10-12 reps for each exercise:\nIncline Barbell Bench Press\nDumbbell Flyes\nSeated Cable Rows\nDumbbell Shoulder Press\nSkull Crushers\nDumbbell Lateral Raises\nCool Down (10 min)\nGentle stretching focusing on chest, shoulders, and triceps.', 
    'Lower Body\nWarm-Up (10 min)\nDynamic stretches: Leg swings, hip openers, and light jogging.\nLower Body Routine (40 min)\nPerform 3 sets of 10-12 reps for each exercise:\nDeadlifts (Conventional or Sumo)\nBulgarian Split Squats\nLeg Extensions (Machine)\nSeated Calf Raises\nLateral Lunges\nHip Thrusts (Barbell)\nCool Down (10 min)\nGentle stretching focusing on quadriceps, hamstrings, and calves.', 
    'Core & Cardio\nWarm-Up (10 min)\nDynamic stretches: Light jogging and torso twists.\nCore & Cardio Routine (40 min)\nPerform 3 sets of the following:\nPlank\nDuration: 30-60 sec\nBicycle Crunches\nReps: 15-20 per side\nHanging Leg Raises or Mountain Climbers\nReps: 10-15\nBurpees\nReps: 8-10\nJump Rope or High Knees\nDuration: 1 min\nCool Down (10 min)\nGentle stretching focusing on core and lower back.'
);


--  40th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, 
    day4_exercises
) 
VALUES (
    '16-30', 'Improve Endurance', 4, 'Intermediate', 
    'Cardio & Core\nWarm-Up (10 min)\nDynamic stretches: Leg swings, arm circles, and light jogging.\nCardio Routine (30 min)\nChoose one of the following options:\nRunning or Jogging: Maintain a steady pace.\nCycling: Moderate to vigorous effort.\nRowing Machine: Steady state for endurance.\nCore Circuit (20 min)\nPerform 3 sets of the following exercises with minimal rest:\nPlank\nDuration: 30-60 sec\nBicycle Crunches\nReps: 15-20 per side\nRussian Twists\nReps: 15-20 per side\nMountain Climbers\nDuration: 30-45 sec\nCool Down (10 min)\nGentle stretching focusing on core and hip flexors.', 
    'Upper Body Endurance\nWarm-Up (10 min)\nDynamic stretches: Arm swings, shoulder circles, and light jogging.\nUpper Body Circuit (40 min)\nPerform 3 sets of 15-20 reps for each exercise:\nPush-Ups (regular or incline)\nDumbbell Bench Press\nBent Over Dumbbell Rows\nDumbbell Shoulder Press\nTricep Dips (bench or chair)\nLateral Raises\nCool Down (10 min)\nGentle stretching focusing on shoulders, chest, and triceps.', 
    'Lower Body Endurance\nWarm-Up (10 min)\nDynamic stretches: Leg swings, hip openers, and light jogging.\nLower Body Circuit (40 min)\nPerform 3 sets of 15-20 reps for each exercise:\nBodyweight Squats\nLunges (Walking or Stationary)\nStep-Ups (Dumbbell or Bodyweight)\nGlute Bridges\nCalf Raises\nLeg Press (Machine)\nCool Down (10 min)\nGentle stretching focusing on quadriceps, hamstrings, and calves.', 
    'Full Body & Cardio\nWarm-Up (10 min)\nDynamic stretches: Full-body movements like arm swings and leg swings.\nFull Body Circuit (30 min)\nPerform 3 sets of 12-15 reps for each exercise with minimal rest:\nBurpees\nKettlebell Swings\nDumbbell Thrusters\nRenegade Rows\nJump Squats\nCardio Finisher (20 min)\nChoose one of the following options:\nHIIT Workout: 30 sec work, 30 sec rest for 4-5 rounds.\nSteady-State Cardio: Running, cycling, or swimming at a moderate pace.\nCool Down (10 min)\nGentle stretching focusing on overall body relaxation.'
);


--  41th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, 
    day4_exercises, day5_exercises
) 
VALUES (
    '16-30', 'Improve Endurance', 5, 'Intermediate', 
    'Cardio & Core\nWarm-Up (10 min)\nDynamic stretches: Leg swings, arm circles, and light jogging.\nCardio Routine (30 min)\nChoose one of the following options:\nRunning or Jogging: Maintain a steady pace.\nCycling: Moderate to vigorous effort.\nRowing Machine: Steady state for endurance.\nCore Circuit (20 min)\nPerform 3 sets of the following exercises with minimal rest:\nPlank\nDuration: 30-60 sec\nBicycle Crunches\nReps: 15-20 per side\nRussian Twists\nReps: 15-20 per side\nMountain Climbers\nDuration: 30-45 sec\nCool Down (10 min)\nGentle stretching focusing on core and hip flexors.', 
    'Upper Body Endurance\nWarm-Up (10 min)\nDynamic stretches: Arm swings, shoulder circles, and light jogging.\nUpper Body Circuit (40 min)\nPerform 3 sets of 15-20 reps for each exercise:\nPush-Ups (regular or incline)\nDumbbell Bench Press\nBent Over Dumbbell Rows\nDumbbell Shoulder Press\nTricep Dips (bench or chair)\nLateral Raises\nCool Down (10 min)\nGentle stretching focusing on shoulders, chest, and triceps.', 
    'Lower Body Endurance\nWarm-Up (10 min)\nDynamic stretches: Leg swings, hip openers, and light jogging.\nLower Body Circuit (40 min)\nPerform 3 sets of 15-20 reps for each exercise:\nBodyweight Squats\nLunges (Walking or Stationary)\nStep-Ups (Dumbbell or Bodyweight)\nGlute Bridges\nCalf Raises\nLeg Press (Machine)\nCool Down (10 min)\nGentle stretching focusing on quadriceps, hamstrings, and calves.', 
    'Cardio Intervals\nWarm-Up (10 min)\nDynamic stretches: Full-body movements like arm swings and leg swings.\nCardio Intervals (40 min)\nAlternate between high and low intensity. Example:\nRunning or Cycling:\n1 min sprint/fast pace\n2 min jog/slow pace\nRepeat for 30 minutes.\nCore Stability Work (10 min)\nPerform 3 sets of:\nSide Planks: 30-45 sec each side\nLeg Raises: 12-15 reps\nCool Down (10 min)\nGentle stretching focusing on overall body relaxation.', 
    'Full Body Circuit\nWarm-Up (10 min)\nDynamic stretches: Full-body movements like arm swings and leg swings.\nFull Body Circuit (40 min)\nPerform 3 sets of 12-15 reps for each exercise with minimal rest:\nBurpees\nKettlebell Swings\nDumbbell Thrusters\nRenegade Rows\nJump Squats\nBattle Ropes (if available)\nDuration: 30-45 sec\nCool Down (10 min)\nGentle stretching focusing on overall body relaxation.'
);


--  42nd data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, 
    day4_exercises, day5_exercises, day6_exercises
) 
VALUES (
    '16-30', 'Improve Endurance', 6, 'Intermediate', 
    'Day 1: Cardio & Core\nWarm-Up (10 min)\nDynamic stretches: Leg swings, arm circles, and light jogging.\nCardio Routine (30 min)\nChoose one of the following options:\nRunning or Jogging: Maintain a steady pace.\nCycling: Moderate to vigorous effort.\nRowing Machine: Steady state for endurance.\nCore Circuit (20 min)\nPerform 3 sets of the following exercises with minimal rest:\nPlank: Duration 30-60 sec\nBicycle Crunches: Reps 15-20 per side\nRussian Twists: Reps 15-20 per side\nMountain Climbers: Duration 30-45 sec.', 
    'Day 2: Upper Body Endurance\nWarm-Up (10 min)\nDynamic stretches: Arm swings, shoulder circles, and light jogging.\nUpper Body Circuit (40 min)\nPerform 3 sets of 15-20 reps for each exercise:\nPush-Ups (regular or incline)\nDumbbell Bench Press\nBent Over Dumbbell Rows\nDumbbell Shoulder Press\nTricep Dips (bench or chair)\nLateral Raises.', 
    'Day 3: Lower Body Endurance\nWarm-Up (10 min)\nDynamic stretches: Leg swings, hip openers, and light jogging.\nLower Body Circuit (40 min)\nPerform 3 sets of 15-20 reps for each exercise:\nBodyweight Squats\nLunges (Walking or Stationary)\nStep-Ups (Dumbbell or Bodyweight)\nGlute Bridges\nCalf Raises\nLeg Press (Machine).', 
    'Day 4: Cardio Intervals\nWarm-Up (10 min)\nDynamic stretches: Full-body movements like arm swings and leg swings.\nCardio Intervals (40 min)\nAlternate between high and low intensity:\nRunning or Cycling:\n1 min sprint/fast pace\n2 min jog/slow pace\nRepeat for 30 minutes.\nCore Stability Work (10 min)\nPerform 3 sets of:\nSide Planks: 30-45 sec each side\nLeg Raises: 12-15 reps.', 
    'Day 5: Full Body Circuit\nWarm-Up (10 min)\nDynamic stretches: Full-body movements like arm swings and leg swings.\nFull Body Circuit (40 min)\nPerform 3 sets of 12-15 reps for each exercise with minimal rest:\nBurpees\nKettlebell Swings\nDumbbell Thrusters\nRenegade Rows\nJump Squats\nBattle Ropes (if available): Duration 30-45 sec.', 
    'Day 6: Active Recovery or Light Cardio\nLight Cardio (30-45 min)\nChoose a low-intensity option:\nWalking: Maintain a brisk pace.\nCycling: Easy pace.\nSwimming: Steady pace focusing on technique.\nMobility and Stretching (20-30 min)\nIncorporate yoga or dynamic stretching to enhance flexibility and aid recovery.'
);



--  43rd data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, 
    day4_exercises
) 
VALUES (
    '16-30', 'Enhanced Flexibility', 4, 'Intermediate', 
    'Day 1: Full Body Stretch & Mobility\nWarm-Up (10 min)\nDynamic stretches: Arm circles, leg swings, and torso twists.\nFull Body Stretch Routine (40 min)\nHold each stretch for 30-60 seconds. Perform 2-3 rounds:\nCat-Cow Stretch\nChild’s Pose\nStanding Forward Bend\nLunging Hip Flexor Stretch\nSeated Hamstring Stretch\nCobra Pose\nFigure Four Stretch (for hips).\nCool Down (10 min)\nGentle stretching focusing on areas of tension.', 
    'Day 2: Upper Body Flexibility\nWarm-Up (10 min)\nDynamic stretches: Arm swings, shoulder rolls, and neck circles.\nUpper Body Stretch Routine (40 min)\nHold each stretch for 30-60 seconds. Perform 2-3 rounds:\nNeck Stretch (Side to Side)\nShoulder Stretch (Cross-body)\nTriceps Stretch (Overhead)\nChest Stretch (Doorway or Wall)\nUpper Back Stretch (Seated or Standing)\nWrist Flexor Stretch\nThoracic Spine Stretch (Seated or Standing).\nCool Down (10 min)\nGentle stretching focusing on shoulders and upper body.', 
    'Day 3: Lower Body Flexibility\nWarm-Up (10 min)\nDynamic stretches: Leg swings, walking lunges, and ankle circles.\nLower Body Stretch Routine (40 min)\nHold each stretch for 30-60 seconds. Perform 2-3 rounds:\nQuad Stretch (Standing or Lying)\nHamstring Stretch (Seated or Standing)\nCalf Stretch (Wall or Floor)\nButterfly Stretch\nPigeon Pose\nLateral Lunge Stretch\nSeated Forward Bend.\nCool Down (10 min)\nGentle stretching focusing on hips and legs.', 
    'Day 4: Active Recovery & Core Stability\nActive Recovery (30 min)\nChoose a low-intensity option:\nWalking: Maintain a brisk pace.\nSwimming: Focus on gentle strokes.\nYoga: Gentle flow focusing on flexibility.\nCore Stability Work (20 min)\nPerform 2-3 sets of each exercise with 10-15 reps:\nPlank: Duration 30-60 sec\nSide Plank: Duration 20-30 sec each side\nDead Bug\nBird Dog\nSuperman Exercise.\nCool Down (10 min)\nGentle stretching focusing on overall body relaxation.'
);


--  44th data
INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, 
    day4_exercises, day5_exercises
) 
VALUES (
    '16-30', 'Enhanced Flexibility', 5, 'Intermediate', 
    'Day 1: Full Body Stretch & Mobility\nWarm-Up (10 min)\nDynamic stretches: Arm circles, leg swings, and torso twists.\nFull Body Stretch Routine (40 min)\nHold each stretch for 30-60 seconds. Perform 2-3 rounds:\nCat-Cow Stretch\nChild’s Pose\nStanding Forward Bend\nLunging Hip Flexor Stretch\nSeated Hamstring Stretch\nCobra Pose\nFigure Four Stretch (for hips).\nCool Down (10 min)\nGentle stretching focusing on areas of tension.', 
    'Day 2: Upper Body Flexibility\nWarm-Up (10 min)\nDynamic stretches: Arm swings, shoulder rolls, and neck circles.\nUpper Body Stretch Routine (40 min)\nHold each stretch for 30-60 seconds. Perform 2-3 rounds:\nNeck Stretch (Side to Side)\nShoulder Stretch (Cross-body)\nTriceps Stretch (Overhead)\nChest Stretch (Doorway or Wall)\nUpper Back Stretch (Seated or Standing)\nWrist Flexor Stretch\nThoracic Spine Stretch (Seated or Standing).\nCool Down (10 min)\nGentle stretching focusing on shoulders and upper body.', 
    'Day 3: Lower Body Flexibility\nWarm-Up (10 min)\nDynamic stretches: Leg swings, walking lunges, and ankle circles.\nLower Body Stretch Routine (40 min)\nHold each stretch for 30-60 seconds. Perform 2-3 rounds:\nQuad Stretch (Standing or Lying)\nHamstring Stretch (Seated or Standing)\nCalf Stretch (Wall or Floor)\nButterfly Stretch\nPigeon Pose\nLateral Lunge Stretch\nSeated Forward Bend.\nCool Down (10 min)\nGentle stretching focusing on hips and legs.', 
    'Day 4: Active Recovery & Core Stability\nActive Recovery (30 min)\nChoose a low-intensity option:\nWalking: Maintain a brisk pace.\nSwimming: Focus on gentle strokes.\nYoga: Gentle flow focusing on flexibility.\nCore Stability Work (20 min)\nPerform 2-3 sets of each exercise with 10-15 reps:\nPlank: Duration 30-60 sec\nSide Plank: Duration 20-30 sec each side\nDead Bug\nBird Dog\nSuperman Exercise.\nCool Down (10 min)\nGentle stretching focusing on overall body relaxation.', 
    'Day 5: Dynamic Flexibility and Mobility\nWarm-Up (10 min)\nDynamic movements: High knees, butt kicks, and leg swings.\nDynamic Flexibility Routine (40 min)\nPerform each movement for 10-15 reps or 30-60 seconds:\nArm Crossovers\nHip Circles\nWalking Lunges with a Twist\nInchworms\nLeg Swings (Front to Back and Side to Side)\nKneeling Hip Flexor Stretch (Dynamic).\nCool Down (10 min)\nGentle stretching focusing on areas that feel tight.'
);


--  45th data

INSERT INTO workout_plans (
    age_range, goal, days_per_week, intensity, 
    day1_exercises, day2_exercises, day3_exercises, 
    day4_exercises, day5_exercises, day6_exercises
) 
VALUES (
    '16-30', 'Enhanced Flexibility', 6, 'Intermediate', 
    'Day 1: Full Body Stretch & Mobility\nWarm-Up (10 min)\nDynamic stretches: Arm circles, leg swings, and torso twists.\nFull Body Stretch Routine (40 min)\nHold each stretch for 30-60 seconds. Perform 2-3 rounds:\nCat-Cow Stretch\nChild’s Pose\nStanding Forward Bend\nLunging Hip Flexor Stretch\nSeated Hamstring Stretch\nCobra Pose\nFigure Four Stretch (for hips).\nCool Down (10 min)\nGentle stretching focusing on areas of tension.', 
    'Day 2: Upper Body Flexibility\nWarm-Up (10 min)\nDynamic stretches: Arm swings, shoulder rolls, and neck circles.\nUpper Body Stretch Routine (40 min)\nHold each stretch for 30-60 seconds. Perform 2-3 rounds:\nNeck Stretch (Side to Side)\nShoulder Stretch (Cross-body)\nTriceps Stretch (Overhead)\nChest Stretch (Doorway or Wall)\nUpper Back Stretch (Seated or Standing)\nWrist Flexor Stretch\nThoracic Spine Stretch (Seated or Standing).\nCool Down (10 min)\nGentle stretching focusing on shoulders and upper body.', 
    'Day 3: Lower Body Flexibility\nWarm-Up (10 min)\nDynamic stretches: Leg swings, walking lunges, and ankle circles.\nLower Body Stretch Routine (40 min)\nHold each stretch for 30-60 seconds. Perform 2-3 rounds:\nQuad Stretch (Standing or Lying)\nHamstring Stretch (Seated or Standing)\nCalf Stretch (Wall or Floor)\nButterfly Stretch\nPigeon Pose\nLateral Lunge Stretch\nSeated Forward Bend.\nCool Down (10 min)\nGentle stretching focusing on hips and legs.', 
    'Day 4: Active Recovery & Core Stability\nActive Recovery (30 min)\nChoose a low-intensity option:\nWalking: Maintain a brisk pace.\nSwimming: Focus on gentle strokes.\nYoga: Gentle flow focusing on flexibility.\nCore Stability Work (20 min)\nPerform 2-3 sets of each exercise with 10-15 reps:\nPlank: Duration 30-60 sec\nSide Plank: Duration 20-30 sec each side\nDead Bug\nBird Dog\nSuperman Exercise.\nCool Down (10 min)\nGentle stretching focusing on overall body relaxation.', 
    'Day 5: Dynamic Flexibility and Mobility\nWarm-Up (10 min)\nDynamic movements: High knees, butt kicks, and leg swings.\nDynamic Flexibility Routine (40 min)\nPerform each movement for 10-15 reps or 30-60 seconds:\nArm Crossovers\nHip Circles\nWalking Lunges with a Twist\nInchworms\nLeg Swings (Front to Back and Side to Side)\nKneeling Hip Flexor Stretch (Dynamic).\nCool Down (10 min)\nGentle stretching focusing on areas that feel tight.', 
    'Day 6: Yoga Flow for Flexibility\nWarm-Up (5 min)\nGentle movements: Deep breathing and light neck and shoulder rolls.\nYoga Flow (45 min)\nInclude a series of poses focusing on flexibility and breath:\nSun Salutations (5 rounds)\nDownward Dog\nWarrior I and II\nTriangle Pose\nSeated Forward Bend\nBridge Pose\nHappy Baby Pose\nSavasana (Final Relaxation).\nCool Down (10 min)\nEnd with deep breathing and light stretching.'
);


