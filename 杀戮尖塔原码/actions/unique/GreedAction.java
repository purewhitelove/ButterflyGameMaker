// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GreedAction.java

package com.megacrit.cardcrawl.actions.unique;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.Hitbox;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.monsters.MonsterGroup;
import com.megacrit.cardcrawl.powers.MinionPower;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.vfx.GainPennyEffect;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;
import java.util.ArrayList;

public class GreedAction extends AbstractGameAction
{

    public GreedAction(AbstractCreature target, DamageInfo info, int goldAmount)
    {
        this.info = info;
        setValues(target, info);
        increaseGold = goldAmount;
        actionType = com.megacrit.cardcrawl.actions.AbstractGameAction.ActionType.DAMAGE;
        duration = 0.1F;
    }

    public void update()
    {
        if(duration == 0.1F && target != null)
        {
            AbstractDungeon.effectList.add(new FlashAtkImgEffect(target.hb.cX, target.hb.cY, com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect.BLUNT_HEAVY));
            target.damage(info);
            if((((AbstractMonster)target).isDying || target.currentHealth <= 0) && !target.halfDead && !target.hasPower("Minion"))
            {
                AbstractDungeon.player.gainGold(increaseGold);
                for(int i = 0; i < increaseGold; i++)
                    AbstractDungeon.effectList.add(new GainPennyEffect(source, target.hb.cX, target.hb.cY, source.hb.cX, source.hb.cY, true));

            }
            if(AbstractDungeon.getCurrRoom().monsters.areMonstersBasicallyDead())
                AbstractDungeon.actionManager.clearPostCombatActions();
        }
        tickDuration();
    }

    private int increaseGold;
    private DamageInfo info;
    private static final float DURATION = 0.1F;
}
