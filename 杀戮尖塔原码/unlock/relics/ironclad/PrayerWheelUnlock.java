// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PrayerWheelUnlock.java

package com.megacrit.cardcrawl.unlock.relics.ironclad;

import com.megacrit.cardcrawl.helpers.RelicLibrary;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.relics.PrayerWheel;
import com.megacrit.cardcrawl.unlock.AbstractUnlock;

public class PrayerWheelUnlock extends AbstractUnlock
{

    public PrayerWheelUnlock()
    {
        type = com.megacrit.cardcrawl.unlock.AbstractUnlock.UnlockType.RELIC;
        relic = RelicLibrary.getRelic("Prayer Wheel");
        key = relic.relicId;
        title = relic.name;
    }
}
