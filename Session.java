import java.io.Serializable;
import java.time.LocalTime;
public class Session implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int nextSessionID = 1;
    private int sessionID;
    private Machine machine;
    private int startTime;
    private int endTime;
    private boolean status;

    // Creates a session object with the attributes machine, startTime, endTime
    public Session(Machine machine, int startTime, int endTime) {
        this.sessionID = nextSessionID++;
        this.machine = machine;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = true;
    }

    //returns start time formatted as a string
    public String getStartTime() {
        return formatTime(startTime);
    }

    //returns end time formatted as a string
    public String getEndTime() {
        return formatTime(endTime);
    }

    public int getSessionID() {
        return sessionID;
    }

    //converts time to minutes and formats the result as a string
    private String formatTime(int minutes) {
        int hours = minutes / 60;
        int mins = minutes % 60;
        return String.format("%02d:%02d", hours, mins);
    }

    public Machine getMachine() {
        return machine;
    }

    // returns the status of the session
    public boolean getStatus() {
        return status;
    }

    //sets the status to false showing that the mark is taken and shows that the machine is being used
    public void markTaken(){
        status = false;
        machine.markUnavailable();
    }

    //sets the status to true showing that the mark is free and shows that the machine is available
    public void markFree(){
        this.status = true;
        machine.markAvailable();
    }

    public void extendSession(int additionalTime) {
        // Implementation to extend session
        this.endTime += additionalTime;
        System.out.println("Session extended by " + additionalTime + " minutes.");
    }

    public void cancelSession() {
        // Implementation to cancel session
        this.status = true;
        System.out.println("Session ID " + sessionID + " has been canceled.");
    }

    //Returns a string representation of the session
    public String toString() { 
        return "Session{" + "sessionID=" + sessionID + ", machine=" + machine + ", startTime='" + getStartTime() + '\'' + ", endTime='" + getEndTime() + '\'' + ", status=" + status + '}';
    }
}
