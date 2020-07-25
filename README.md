# InfiniteRecharge2020

Code for FRC 687's 2020 Robot, [Thomas](https://www.thebluealliance.com/team/687/2020). This was our second year using [NerdyLib](https://github.com/nerdherd/NerdyLib), allowing us to reuse large amounts of code developed for our 2019 robots. 

## Main Features

- [Flywheel shooter](https://github.com/DylanB5402/InfiniteRecharge2020/blob/master/src/main/java/frc/robot/subsystems/Shooter.java) controlled by velocity feedforward and TalonFX onboard velocity PID
- Continuous variable [hood](https://github.com/DylanB5402/InfiniteRecharge2020/blob/master/src/main/java/frc/robot/subsystems/Hood.java) controlled by TalonSRX Motion Magic with rio-side feedforwards, sharing code with 2019's [arm](https://github.com/nerdherd/NerdyLib/blob/89e4f9c0e72c3707f2bec42734a66a9e26c0d859/src/main/java/com/nerdherd/lib/motor/single/mechanisms/SingleMotorArm.java) subsystem
- [Auto aiming](https://github.com/DylanB5402/InfiniteRecharge2020/blob/master/src/main/java/frc/robot/commands/vision/TurnToAngle.java) at the vision target using a [Jevois](https://github.com/DylanB5402/InfiniteRecharge2020/blob/master/src/main/java/frc/robot/subsystems/Jevois.java) or [Limelight](https://github.com/DylanB5402/InfiniteRecharge2020/blob/master/src/main/java/frc/robot/subsystems/Limelight.java) camera
- [On-the-fly hood angle calculation](https://github.com/DylanB5402/InfiniteRecharge2020/blob/master/src/main/java/frc/robot/commands/vision/DistanceToAngle.java) for shooting from 10-20 feet from the goal using vision data 
- Multiple [autonomous modes](https://github.com/DylanB5402/InfiniteRecharge2020/tree/master/src/main/java/frc/robot/commands/auto) using WPILib's ramsete controller and trajectory generation tools
- Dual [elevators](https://github.com/DylanB5402/InfiniteRecharge2020/blob/master/src/main/java/frc/robot/subsystems/Climber.java) for climbing using 2019's [elevator](https://github.com/nerdherd/NerdyLib/blob/89e4f9c0e72c3707f2bec42734a66a9e26c0d859/src/main/java/com/nerdherd/lib/motor/single/mechanisms/SingleMotorElevator.java) code

We wrote our second [software binder](https://drive.google.com/file/d/1txhhiYvTkaPiR2WDwDQ2dvdEqKSZEBjZ/view?usp=sharing) describing the software and controls used on Thomas in-depth.