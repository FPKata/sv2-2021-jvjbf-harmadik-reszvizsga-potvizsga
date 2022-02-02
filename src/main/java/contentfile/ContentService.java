package contentfile;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ContentService
{
    private Set<User> users;
    private Set<Content> contents;

    void registerUser(String name, String password) {
        if (users.stream().anyMatch(user -> user.getUserName().equals(name))) {
            users.add(new User(name, password));
        }
    }

    void addContent(Content content) {
        if (contents.stream().anyMatch(c -> c.getTitle().equals(content.getTitle())))
        {
            contents.add(content);
        }
    }

    void logIn(String username, String password) {
        List<User> us = users.stream().filter(u -> u.getUserName().equals(username))
                .collect(Collectors.toList());

        if (us.isEmpty()) {
            throw new IllegalArgumentException("");
        }

        User u = us.get(0);
        if (u.checkPassword(password)) {
            u.setLogIn(true);
        } else {
            throw new IllegalArgumentException("");
        }
    }

    void clickOnContent(User user, Content content) {
        if (user.getLogIn() && (!content.isPremiumContent() || user.isPremium())) {
            content.click(user);
        }
    }
}

