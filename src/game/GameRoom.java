package game;

import objects.Riddle;
import files.PropertiesConfig;
import gui.rooms.InitRoomGui;
import java.util.ArrayList;
import objects.Team;

/**
 *
 * @author Jermy
 */
public class GameRoom extends Thread {

    private ArrayList<Boolean> padlocksOpen;
    private ArrayList<Riddle> riddles;
    private Game game;
    private String currentRoom = InitRoomGui.ROOM_3;
    private Team team;

    public GameRoom(Game game, Team team) {
        this.padlocksOpen = new ArrayList<>();
        this.riddles = new ArrayList<>();
        this.game = game;
        this.team = team;
    }

    public ArrayList<Boolean> getPadlocksOpen() {
        return padlocksOpen;
    }

    public void setPadlocksOpen(ArrayList<Boolean> padlocksOpen) {
        this.padlocksOpen = padlocksOpen;
    }

    public ArrayList<Riddle> getRiddles() {
        return riddles;
    }

    public void setRiddles(ArrayList<Riddle> riddles) {
        this.riddles = riddles;
    }

    private void winnner() {
        int count = 0;
        for (int i = 0; i < PropertiesConfig.getInstance().getProperties("padlocksCount"); i++) {
            count = (padlocksOpen.get(i) == true) ? count++ : count;
        }
        if (count == padlocksOpen.size()) {
            game.setFinishGame(true);
        }
    }

    public boolean tryOpen(String msg) {
        for (int i = 0; i < riddles.size(); i++) {
            if (riddles.get(i).isCorrect(msg)) {
                padlocksOpen.set(i, true);
                winnner();
                return true;
            }
        }
        return false;
    }

    public String getCurrentRoom() {
        return this.currentRoom;
    }
}
