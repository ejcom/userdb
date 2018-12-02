package app.model;

import app.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static Model ourInstance = new Model();

    private List<User> model;

    public static Model getInstance() {
        return ourInstance;
    }

    private Model() {
        model = new ArrayList<User>();
    }

    public void add(User user) {
        model.add(user);
    }

    public List<String> list() {
        return model.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public void remove(User user) {
        if (model.contains(user)) {
            model.remove(user);
        }
    }

    public void edit(User oldUser, User newUser) {
        if (model.contains(oldUser)) {
            model.set(model.indexOf(oldUser), newUser);
        }
    }
}
