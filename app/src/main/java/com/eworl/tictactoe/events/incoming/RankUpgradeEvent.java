package com.eworl.tictactoe.events.incoming;

/**
 * Created by Maninder Taggar on 26/1/17.
 */

public class RankUpgradeEvent extends IncomingEvent {
    public static final String identity = "RankUpgradeEvent";

    @Override
    public void setIdentity() {
        super.identity = identity;
    }

}
