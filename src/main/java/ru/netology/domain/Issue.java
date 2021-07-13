package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Issue  implements Comparable<Issue> {
    private int id;
    private String name;
    private String body;
    private String author;
    public HashSet<String> assignee;
    private boolean status; //open = true, closed = false
    //FixMe - хранить теги, assignee и некоторые другие поля
    // в виде Set (т.к. например, теги не могут дублироваться)
    public HashSet<String> tag;
 //   private Date date;

    @Override
    public int compareTo(Issue o) {
        return id - o.id;
    }

}
