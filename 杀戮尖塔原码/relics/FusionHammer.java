// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FusionHammer.java

package com.megacrit.cardcrawl.relics;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.ui.campfire.AbstractCampfireOption;
import com.megacrit.cardcrawl.ui.campfire.SmithOption;
import java.util.ArrayList;

// Referenced classes of package com.megacrit.cardcrawl.relics:
//            AbstractRelic

public class FusionHammer extends AbstractRelic
{

    public FusionHammer()
    {
        super("Fusion Hammer", "burnHammer.png", AbstractRelic.RelicTier.BOSS, AbstractRelic.LandingSound.HEAVY);
    }

    public String getUpdatedDescription()
    {
        if(AbstractDungeon.player != null)
            return setDescription(AbstractDungeon.player.chosenClass);
        else
            return setDescription(null);
    }

    private String setDescription(com.megacrit.cardcrawl.characters.AbstractPlayer.PlayerClass c)
    {
        return (new StringBuilder()).append(DESCRIPTIONS[1]).append(DESCRIPTIONS[0]).toString();
    }

    public void updateDescription(com.megacrit.cardcrawl.characters.AbstractPlayer.PlayerClass c)
    {
        description = setDescription(c);
        tips.clear();
        tips.add(new PowerTip(name, description));
        initializeTips();
    }

    public void onEquip()
    {
        AbstractDungeon.player.energy.energyMaster++;
    }

    public void onUnequip()
    {
        AbstractDungeon.player.energy.energyMaster--;
    }

    public boolean canUseCampfireOption(AbstractCampfireOption option)
    {
        if((option instanceof SmithOption) && option.getClass().getName().equals(com/megacrit/cardcrawl/ui/campfire/SmithOption.getName()))
        {
            ((SmithOption)option).updateUsability(false);
            return false;
        } else
        {
            return true;
        }
    }

    public AbstractRelic makeCopy()
    {
        return new FusionHammer();
    }

    public static final String ID = "Fusion Hammer";
}
