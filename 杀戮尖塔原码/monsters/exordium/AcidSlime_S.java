// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AcidSlime_S.java

package com.megacrit.cardcrawl.monsters.exordium;

import com.badlogic.gdx.math.MathUtils;
import com.esotericsoftware.spine.AnimationState;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.actions.animations.AnimateSlowAttackAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.SlimeAnimListener;
import com.megacrit.cardcrawl.localization.LocalizedStrings;
import com.megacrit.cardcrawl.localization.MonsterStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;
import com.megacrit.cardcrawl.powers.WeakPower;
import com.megacrit.cardcrawl.random.Random;
import java.util.ArrayList;

public class AcidSlime_S extends AbstractMonster
{

    public AcidSlime_S(float x, float y, int poisonAmount)
    {
        super(NAME, "AcidSlime_S", 12, 0.0F, -4F, 130F, 100F, null, x, y);
        if(AbstractDungeon.ascensionLevel >= 7)
            setHp(9, 13);
        else
            setHp(8, 12);
        if(AbstractDungeon.ascensionLevel >= 2)
            damage.add(new DamageInfo(this, 4));
        else
            damage.add(new DamageInfo(this, 3));
        if(poisonAmount >= 1)
            powers.add(new PoisonPower(this, this, poisonAmount));
        loadAnimation("images/monsters/theBottom/slimeS/skeleton.atlas", "images/monsters/theBottom/slimeS/skeleton.json", 1.0F);
        com.esotericsoftware.spine.AnimationState.TrackEntry e = state.setAnimation(0, "idle", true);
        e.setTime(e.getEndTime() * MathUtils.random());
        state.addListener(new SlimeAnimListener());
    }

    public void takeTurn()
    {
        switch(nextMove)
        {
        case 1: // '\001'
            AbstractDungeon.actionManager.addToBottom(new AnimateSlowAttackAction(this));
            AbstractDungeon.actionManager.addToBottom(new DamageAction(AbstractDungeon.player, (DamageInfo)damage.get(0), com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect.BLUNT_HEAVY));
            setMove((byte)2, com.megacrit.cardcrawl.monsters.AbstractMonster.Intent.DEBUFF);
            break;

        case 2: // '\002'
            AbstractDungeon.actionManager.addToBottom(new AnimateSlowAttackAction(this));
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, this, new WeakPower(AbstractDungeon.player, 1, true), 1));
            setMove((byte)1, com.megacrit.cardcrawl.monsters.AbstractMonster.Intent.ATTACK, ((DamageInfo)damage.get(0)).base);
            break;
        }
    }

    protected void getMove(int num)
    {
        if(AbstractDungeon.ascensionLevel >= 17)
        {
            if(lastTwoMoves((byte)1))
                setMove((byte)1, com.megacrit.cardcrawl.monsters.AbstractMonster.Intent.ATTACK, ((DamageInfo)damage.get(0)).base);
            else
                setMove((byte)2, com.megacrit.cardcrawl.monsters.AbstractMonster.Intent.DEBUFF);
        } else
        if(AbstractDungeon.aiRng.randomBoolean())
            setMove((byte)1, com.megacrit.cardcrawl.monsters.AbstractMonster.Intent.ATTACK, ((DamageInfo)damage.get(0)).base);
        else
            setMove((byte)2, com.megacrit.cardcrawl.monsters.AbstractMonster.Intent.DEBUFF);
    }

    public static final String ID = "AcidSlime_S";
    private static final MonsterStrings monsterStrings;
    public static final String NAME;
    public static final String MOVES[];
    public static final String DIALOG[];
    public static final int HP_MIN = 8;
    public static final int HP_MAX = 12;
    public static final int A_2_HP_MIN = 9;
    public static final int A_2_HP_MAX = 13;
    public static final int TACKLE_DAMAGE = 3;
    public static final int WEAK_TURNS = 1;
    public static final int A_2_TACKLE_DAMAGE = 4;
    private static final byte TACKLE = 1;
    private static final byte DEBUFF = 2;

    static 
    {
        monsterStrings = CardCrawlGame.languagePack.getMonsterStrings("AcidSlime_S");
        NAME = monsterStrings.NAME;
        MOVES = monsterStrings.MOVES;
        DIALOG = monsterStrings.DIALOG;
    }
}
