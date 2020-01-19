package sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {

    private Item item = null;
    private Channel channel = null;
    private StringBuilder data = null;

    boolean bTitle = false;
    boolean cTitle = false;

    boolean bDesc = false;
    boolean cDesc = false;

    boolean bLink = false;
    boolean cLink = false;

    boolean bGuid = false;
    boolean bPubDate = false;

    public Channel getChannel() {
        return channel;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("channel"))
            channel = new Channel();
        if (qName.equalsIgnoreCase("item"))
            item = new Item();
        else if (qName.equalsIgnoreCase("title")) {
            if (item != null)
                bTitle = true;
            else
                cTitle = true;
        } else if (qName.equalsIgnoreCase("description")) {
            if (item != null)
                bDesc = true;
            else
                cDesc = true;
        } else if (qName.equalsIgnoreCase("link")) {
            if (item != null)
                bLink = true;
            else
                cLink = true;
        } else if (qName.equalsIgnoreCase("guid")) {
            bGuid = true;
        } else if (qName.equalsIgnoreCase("pubDate")) {
            bPubDate = true;
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (cTitle) {
            channel.setTitle(data.toString());
            cTitle = false;
        } else if (cDesc) {
            channel.setDescription(data.toString());
            cDesc = false;
        } else if (cLink) {
            channel.setLink(data.toString());
            cLink = false;
        }
        else {
            if (bTitle) {
                item.setTitle(data.toString());
                bTitle = false;
            } else if (bDesc) {
                item.setDescription(data.toString());
                bDesc = false;
            } else if (bLink) {
                item.setLink(data.toString());
                bLink = false;
            } else if (bGuid) {
                item.setGuid(Integer.parseInt(data.toString()));
                bGuid = false;
            } else if (bPubDate) {
                item.setPubDate(data.toString());
                bPubDate = false;
            }
        }

        if (qName.equalsIgnoreCase("item")) {
            channel.getItemList().add(item);
            item = null;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }
}

