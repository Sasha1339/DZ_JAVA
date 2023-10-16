package ru.mpei.DZ7;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Streamer {
    private String name;
    public double averageMark;
    private int age;
    private int subscribes;
    private List<Platform> platforms;
}
