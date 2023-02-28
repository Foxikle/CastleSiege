package dev.foxikle.castlesiege;

public enum GameState {
    PREWAITING(0),
    WAITING(1),
    VOTING(2),
    PRESIEGE(3),
    SIEGE(4),
    VICTORY(5),
    CLEANUP(6);

    private final int order;

    GameState(int order) {
        this.order = order;
    }
    public int getOrder(){
        return order;
    }
}
