package org.project.AutoDriving;

import org.project.AutoDriving.Classes.AutoVehiclesClass;

import java.util.*;


public class AutoDrivingAssignmentClass {

    static ArrayList<List<Integer>> index = new ArrayList<>();

    static List<String> movementDirections = Arrays.asList("L", "R");

    static ArrayList<Integer> listofCarsAddedByCustomer;

    static Map<Integer, AutoVehiclesClass> carBeforeSimulationList;

    static ArrayList<Integer> maxIndex = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        mainMethod();
    }

    public static void mainMethod() throws Exception {
        System.out.println("Welcome to Auto Driving Car Simulation!\n" +
                "\n" +
                "Please enter the width and height of the simulation field in x y format:");

        Scanner inputScanner = new Scanner(System.in);

        Integer num1 = inputScanner.nextInt();

        Integer num2 = inputScanner.nextInt();

        maxIndex.add(0, num1);
        maxIndex.add(1, num2);

        System.out.println( "You have created a field of " + num1 + " x " + num2 + " ." + "Please choose from the following options:\n" +
                "\n" + "[1] Add a car to field" + "\n" +
                "[2] Run simulation" );

        if(inputScanner.nextInt() == 1){
            createaCar();
        } else {
            System.exit(0);
        }

        System.out.println("You have created a car." + "Please choose from the following options:\n" +
                "\n" + "[1] Add a car to field" + "\n" +
                "[2] Run simulation" );

        if(inputScanner.nextInt() == 1){
            createaCar();
        } else {
            runsimulation();
        }
    }

    private static void createaCar() {

        AutoVehiclesClass newCar = new AutoVehiclesClass();

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Please enter the name of the car:");

        newCar.setName(inputScanner.next());

        System.out.println("Please enter initial position of car " + newCar.getName() +  "in x y Direction format:");

        newCar.setCurrentDirection(inputScanner.next());
        newCar.setInputDirection(inputScanner.next());

        newCar.index.set(0, inputScanner.nextInt());
        newCar.index.set(1, inputScanner.nextInt());

        System.out.println("Please enter the commands for " + newCar.getName() +  ":");

        String tempDirections = inputScanner.next();
        newCar.setInput(tempDirections);

        ArrayList<Character> ch = (ArrayList<Character>) tempDirections.chars() // Convert String to stream of chars with Int
                .mapToObj(c -> (char) c) // Map each int (char) to Character
                .toList();

        newCar.setInputDirections(ch);

        carBeforeSimulationList.put(listofCarsAddedByCustomer.size(), newCar);

        listofCarsAddedByCustomer.add(listofCarsAddedByCustomer.size(),listofCarsAddedByCustomer.size());



    }


    private static void runsimulation() throws Exception {

        for( int i = (listofCarsAddedByCustomer.size() + 1); i > listofCarsAddedByCustomer.size(); i++ ){

            moveCar(carBeforeSimulationList.get(i), i);

        }

        for (int i = (index.size() + 1); i > index.size(); i++) {


            if(index.get(i) == index.get(i + 1)){

                Scanner inputScanner = new Scanner(System.in);

                System.out.println("After simulation, the result is:\n" + "\n" +
                        "-" + carBeforeSimulationList.get(i).getName() + ", collides with " + carBeforeSimulationList.get(i + 1).getName() + "at" + index.get(i)
                        + "at step" + i + "\n" +
                        "-" + carBeforeSimulationList.get(i + 1).getName() + ", collides with " + carBeforeSimulationList.get(i).getName() + "at" + index.get(i)
                        + "at step" + i + "\n\n" + "Please choose from the following options:\n" +
                        "\n" + "[1] Start over" + "\n" +
                        "[2] Exit" );

                if(inputScanner.nextInt() == 1){
                    mainMethod();
                } else {
                    System.exit(0);
                }

            }

            break;

        }



    }

    private static void moveCar(AutoVehiclesClass Car, Integer integer) throws Exception {

        if(Car.inputDirections.size() > Car.indexOfDirection) {
            String currentInput = String.valueOf(Car.inputDirections.get(Car.indexOfDirection));
            if(movementDirections.contains(currentInput)){
                Car.changeDirections(currentInput);

            } else {
                Car.moveForward(currentInput);
            }

            Car.setIndexOfDirection(Car.indexOfDirection + 1);

            index.add(integer, Car.getIndex());
        }

    }
}