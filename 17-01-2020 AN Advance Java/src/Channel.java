import java.util.ArrayList;
import java.util.List;

public class Channel {
    String title;
    String description;
    String link;
    List<Item> itemList;

    public Channel() {
        itemList = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "Channel title: " + title + "\nChannel desc: " + description + "\nChannel link: " + link + "\n-----------------------------------------------------------------------------------------";
    }
}