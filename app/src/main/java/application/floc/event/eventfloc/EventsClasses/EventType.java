package application.floc.event.eventfloc.EventsClasses;

/**
 * Created by Vanessa on 10/05/2015.
 */
public class EventType {
    private int eventTypeID;
    private String eventType;

    public EventType(int eventTypeID, String eventType) {

        //------should we just make up our own event id nums since you can't add new ones?
        this.eventTypeID = eventTypeID;
        this.eventType = eventType;
    }

    public EventType(){

    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getEventTypeID() {
        return eventTypeID;
    }

    public void setEventTypeID(int eventTypeID) {
        this.eventTypeID = eventTypeID;
    }


}
