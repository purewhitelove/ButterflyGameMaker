// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AnimateFastAttackAction.java

package com.megacrit.cardcrawl.actions.animations;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;

public class AnimateFastAttackAction extends AbstractGameAction
{

    public AnimateFastAttackAction(AbstractCreature owner)
    {
        called = false;
        setValues(null, owner, 0);
        duration = Settings.ACTION_DUR_FAST;
        actionType = com.megacrit.cardcrawl.actions.AbstractGameAction.ActionType.WAIT;
    }

    public void update()
    {
        if(!called)
        {
            source.useFastAttackAnimation();
            called = true;
        }
        tickDuration();
    }

    private boolean called;
}
