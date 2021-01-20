# Co2Emission-Calculator

One Paragraph of project description goes here

## Getting Started

Task is to create a program that returns the amount of CO2-equivalent that will be caused when traveling a given distance using a
given transportation method.

### Prerequisites
To Execute this Application JAVA should be pre-installed in the System,
to install java follow these  [link](https://www.java.com/en/download/help/download_options.html)

Check Whether java installed or not with fallowing command.
```
java -version
```

### Installation
1.Download the project .zip file from  [Project Files](https://sap-my.sharepoint.com/:f:/p/alexander_thierfelder/Erb_I5-3YjBBiHfKq7qOUt0BhDrsJG5g5IPaY8isilJ44A)
and Extract the Project files to Deskotp.

![1Extarctedfile](./images/1Extractedfile.png)

2.Open Terminal and Navigate to source folder
```
cd Desktop/Co2Emission/src
```
![2Navigate](./images/2Navigate.png)

## Compile
We have two java class/Files 1.class Transportation ie Transportation.java and 2.class Co2Emission.  ie Co2Emission.java...
We neeed to compile both the Files and Run the Main Class ie class Co2Emmision.
```
javac Transportation.java
javac Co2Emission.java
java Co2Emission
```
![3Compile](./images/3Compile.png)

## Execution and Testing

The tool can be called with a numeric distance , a unit-of-distance (kilometer km or meter m ) and a transportation-
method.
Named parameters can be put in any order and either use a space ( ) or equal sign ( = ) between key and value.

### Test Scenario-1:

```
$ ./co2-calculator --transportation-method medium-diesel-car --distance 15 --unit-of-distance km

```
### Output-1:
![out1](./images/out1.png)


### Test Scenario-2:

```
$ ./co2-calculator --distance 1800.5 --transportation-method large-petrol-car

```
### Output-2:
![out1](./images/out2.png)



## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

