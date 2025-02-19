// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FocusPower.java

package com.megacrit.cardcrawl.powers;

import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.audio.SoundMaster;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.LocalizedStrings;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.screens.stats.AchievementGrid;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

// Referenced classes of package com.megacrit.cardcrawl.powers:
//            AbstractPower

public class FocusPower extends AbstractPower
{

    public FocusPower(AbstractCreature owner, int amount)
    {
        name = NAME;
        ID = "Focus";
        this.owner = owner;
        this.amount = amount;
        updateDescription();
        loadRegion("focus");
        canGoNegative = true;
    }

    public void playApplyPowerSfx()
    {
        CardCrawlGame.sound.play("POWER_FOCUS", 0.05F);
    }

    public void stackPower(int stackAmount)
    {
        fontScale = 8F;
        amount += stackAmount;
        if(amount == 0)
            addToTop(new RemoveSpecificPowerAction(owner, owner, "Focus"));
        if(amount >= 25)
            UnlockTracker.unlockAchievement("FOCUSED");
        if(amount >= 999)
            amount = 999;
        if(amount <= -999)
            amount = -999;
    }

    public void reducePower(int reduceAmount)
    {
        fontScale = 8F;
        amount -= reduceAmount;
        if(amount == 0)
            addToTop(new RemoveSpecificPowerAction(owner, owner, NAME));
        if(amount >= 999)
            amount = 999;
        if(amount <= -999)
            amount = -999;
    }

    public void updateDescription()
    {
        if(amount > 0)
        {
            description = (new StringBuilder()).append(DESCRIPTIONS[0]).append(amount).append(DESCRIPTIONS[2]).toString();
            type = AbstractPower.PowerType.BUFF;
        } else
        {
            int tmp = -amount;
            description = (new StringBuilder()).append(DESCRIPTIONS[1]).append(tmp).append(DESCRIPTIONS[2]).toString();
            type = AbstractPower.PowerType.DEBUFF;
        }
    }

    public static final String POWER_ID = "Focus";
    private static final PowerStrings powerStrings;
    public static final String NAME;
    public static final String DESCRIPTIONS[];

    static 
    {
        powerStrings = CardCrawlGame.languagePack.getPowerStrings("Focus");
        NAME = powerStrings.NAME;
        DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    }
}
