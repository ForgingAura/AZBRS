package forgingaura.azbrs.handler;

import forgingaura.azbrs.capability.IRace;

public class Race implements IRace {

    private int raceType = 1;
    private int raceLevel = 1;

    @Override
    public void setRaceLevel(int race_level) {
        this.raceLevel = race_level;

    }

    @Override
    public void setRaceType(int race_type) {
        this.raceType = race_type;
    }

    @Override
    public int getRaceType() {
        return raceType;
    }

    @Override
    public int getRaceLevel() {
        return raceLevel;
    }
}
