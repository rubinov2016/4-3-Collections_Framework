package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.List;

public class IssueRepository {
    private List<Issue> items = new ArrayList<>();


    public void setStatusById(int id, boolean status) {
        for (Issue item : items) {
            if (item.getId() == id) {
                item.setStatus(status);
            }
        }
    }

    public List<Issue> getAll() {
        return items;
    }

    public Issue getById(int id) {
        for (Issue item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public List<Issue> getByStatus(boolean status) {
        List<Issue> result = new ArrayList<Issue>();
        for (Issue item : items) {
            if (item.isStatus() == status) {
                result.add(item);
            }
        }
        return result;
    }

    public List<Issue> getOpen() {
        return this.getByStatus(true);
    }

    public List<Issue> getByAuthor(String author) {
        //TODO - интерфейс Predicate.
        // Мы не разбирали подробно функциональные интерфейсы в джаве как более продвинутую и углублённую тему,
        // но если вы сможете по аналогии с Comparator реализовать метод filterBy в менеджере и передавать в него объект,
        // удовлетворяющий интерфейсу Predicate, то это будет полезно.
        List<Issue> result = new ArrayList<Issue>();
        for (Issue item : items) {
            if (item.getAuthor() == author) {
                result.add(item);
            }
        }
        return result;
    }

    public boolean add(Issue item) {
        return items.add(item);
    }

    public boolean remove(Issue item) {
        //exists in List class
        return items.remove(item);
        //
    }

    public List<Issue> getByAssignee(String name) {
        List<Issue> result = new ArrayList<Issue>();
        for (Issue item : items) {
            if (item.assignee != null) { //иначе была ошибка NPE
                if (item.assignee.contains(name)) {
                    result.add(item);
                }
            }
        }
        return result;
    }

    public List<Issue> getByTag(String name) {
        List<Issue> result = new ArrayList<Issue>();
        for (Issue item : items) {
            if (item.tag != null) { //иначе была ошибка NPE
                if (item.tag.contains(name)) {
                    result.add(item);
                }
            }
        }
        return result;
    }

}

