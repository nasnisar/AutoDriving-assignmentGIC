package org.project.AutoDriving.Classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AutoVehiclesClass {

    List<String> cardinalDirections = Arrays.asList("N", "E", "S", "W");

    public String name;

    public String currentDirection;

    public String inputDirection;

    public String input;

    public ArrayList<Integer> index;

    public ArrayList<Integer> workingIndex;

    public ArrayList<Integer> maxIndex;

    public ArrayList<Character> inputDirections;

    public Integer indexOfDirection = 0;

    public void moveForward(String direction) throws Exception {

        if (currentDirection.equalsIgnoreCase("E") || currentDirection.equalsIgnoreCase("W")) {

            if(index.get(0) == maxIndex.get(0) || index.get(0) == 0){
              throw new Exception("Out of Bounds");
            }
            index.set(1, (index.get(1) + 1));
        } else {
            if(index.get(1) == maxIndex.get(1) || index.get(1) == 0){
                throw new Exception("Out of Bounds");
            }
            index.set(0, (index.get(0) + 1));
        }

    }

    public void changeDirections(String direction) throws Exception {
        if(direction.equalsIgnoreCase("L")){

            if(cardinalDirections.indexOf(currentDirection) == 0) {
                setCurrentDirection(cardinalDirections.get(3));
            } else  {
              setCurrentDirection(cardinalDirections.get((cardinalDirections.indexOf(currentDirection)) - 1));
            }
        } else if (direction.equalsIgnoreCase("R")) {

            if(cardinalDirections.indexOf(currentDirection) == 3) {
                setCurrentDirection(cardinalDirections.get(0));
            } else  {
                setCurrentDirection(cardinalDirections.get((cardinalDirections.indexOf(currentDirection)) + 1));
            }

        } else {
            throw new Exception("Out of Bounds");
        }
    }
}
