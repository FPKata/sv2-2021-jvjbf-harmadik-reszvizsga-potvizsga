package contentfile;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseContent implements Content {
    protected String title;
    protected List<User> clickedBy;

    public BaseContent(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<User> clickedBy() {
        return new ArrayList<>(clickedBy);
    }

    @Override
    public void click(User user) {
        clickedBy.add(user);
    }
}
