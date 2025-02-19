// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DrawReductionPower.java

package com.megacrit.cardcrawl.powers;

import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.LocalizedStrings;
import com.megacrit.cardcrawl.localization.PowerStrings;

// Referenced classes of package com.megacrit.cardcrawl.powers:
//            AbstractPower

public class DrawReductionPower extends AbstractPower
{

    public DrawReductionPower(AbstractCreature owner, int amount)
    {
        justApplied = true;
        name = NAME;
        ID = "Draw Reduction";
        this.owner = owner;
        this.amount = amount;
        updateDescription();
        loadRegion("lessdraw");
        type = AbstractPower.PowerType.DEBUFF;
        isTurnBased = true;
    }

    public void onInitialApplication()
    {
        AbstractDungeon.player.gameHandSize--;
    }

    public void atEndOfRound()
    {
        if(justApplied)
        {
            justApplied = false;
            return;
        } else
        {
            addToBot(new ReducePowerAction(owner, owner, "Draw Reduction", 1));
            return;
        }
    }

    public void onRemove()
    {
        AbstractDungeon.player.gameHandSize++;
    }

    public void updateDescription()
    {
        if(amount == 1)
            description = DESCRIPTIONS[0];
        else
            description = (new StringBuilder()).append(DESCRIPTIONS[1]).append(amount).append(DESCRIPTIONS[2]).toString();
    }

    public static final String POWER_ID = "Draw Reduction";
    private static final PowerStrings powerStrings;
    public static final String NAME;
    public static final String DESCRIPTIONS[];
    private boolean justApplied;

    static 
    {
        powerStrings = CardCrawlGame.languagePack.getPowerStrings("Draw Reduction");
        NAME = powerStrings.NAME;
        DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    }
}
