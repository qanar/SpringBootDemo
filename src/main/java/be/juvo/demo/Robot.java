package be.juvo.demo;

import org.springframework.data.annotation.Id;

public class Robot {
    @Id
    public String id;
    public String name;
    public int height;
    public boolean lethal;

    public Robot() {
    }

    public Robot(String name, int height, boolean lethal) {
        this.name = name;
        this.height = height;
        this.lethal = lethal;
    }
}
