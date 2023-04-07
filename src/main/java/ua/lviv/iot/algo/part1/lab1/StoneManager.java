package ua.lviv.iot.algo.part1.lab1;

import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.swing.plaf.synth.SynthStyle;

@NoArgsConstructor
@Getter
public class StoneManager {
    private List<Stone> stones = new LinkedList<>();

    public List<Stone> findAllLegal() {
        return stones
                .stream()
                .filter(stone -> stone.getClass() == PreciousStone.class
                        || stone.getClass() == ArtificialPreciousStone.class)
                .toList();
    }

    public void addStone(Stone stone) {
        stones.add(stone);
    }

    public void addStone(List<Stone> stoneList) {
        stones.addAll(stoneList);
    }

    public List<Stone> findAllLower(int money) {
        return stones.stream().filter(stone -> stone.getFullPrice() <= money).toList();
    }

    public static void main(String[] args) {
        StoneManager stoneManager = new StoneManager();
        stoneManager.addStone(new ArtificialPreciousStone("coal", "black", 1000, 100));
        stoneManager.addStone(new PreciousStone("ruby", "red", 100, 99, 10000));
        stoneManager.addStone(new MethStone("meth", "blue", 2, 95, 40000));
        stoneManager.addStone(new ExplodingStone("not-a-meth", "white", 1, 25000));
        stoneManager.addStone(new ArtificialPreciousStone("coal2", "black", 1000, 100));
        stoneManager.addStone(new PreciousStone("ruby2", "red", 100, 99, 1));
        stoneManager.addStone(new MethStone("meth", "blue", 4, 95, 40000));
        stoneManager.addStone(new ExplodingStone("walter", "white", 1, 25000));
        List<Stone> arr = stoneManager.getStones();
        for (Stone stone : arr) {
            System.out.println(stone.toString());
        }
        List<Stone> arr2 = stoneManager.findAllLegal();
        arr2.stream().forEach(stone-> System.out.println(stone.toString()));

    }
}
