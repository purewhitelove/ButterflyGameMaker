// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Wish.java

package com.megacrit.cardcrawl.cards.purple;

import com.megacrit.cardcrawl.actions.watcher.ChooseOneAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.optionCards.*;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.LocalizedStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import java.util.ArrayList;
import java.util.Iterator;

public class Wish extends AbstractCard
{

    public Wish()
    {
        super("Wish", cardStrings.NAME, "purple/skill/wish", 3, cardStrings.DESCRIPTION, com.megacrit.cardcrawl.cards.AbstractCard.CardType.SKILL, com.megacrit.cardcrawl.cards.AbstractCard.CardColor.PURPLE, com.megacrit.cardcrawl.cards.AbstractCard.CardRarity.RARE, com.megacrit.cardcrawl.cards.AbstractCard.CardTarget.NONE);
        baseDamage = 3;
        baseMagicNumber = 25;
        magicNumber = 25;
        baseBlock = 6;
        exhaust = true;
        tags.add(com.megacrit.cardcrawl.cards.AbstractCard.CardTags.HEALING);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        ArrayList stanceChoices = new ArrayList();
        stanceChoices.add(new BecomeAlmighty());
        stanceChoices.add(new FameAndFortune());
        stanceChoices.add(new LiveForever());
        if(upgraded)
        {
            AbstractCard c;
            for(Iterator iterator = stanceChoices.iterator(); iterator.hasNext(); c.upgrade())
                c = (AbstractCard)iterator.next();

        }
        addToBot(new ChooseOneAction(stanceChoices));
    }

    public void applyPowers()
    {
    }

    public void calculateCardDamage(AbstractMonster abstractmonster)
    {
    }

    public void upgrade()
    {
        if(!upgraded)
        {
            upgradeName();
            upgradeDamage(1);
            upgradeMagicNumber(5);
            upgradeBlock(2);
        }
    }

    public AbstractCard makeCopy()
    {
        return new Wish();
    }

    public static final String ID = "Wish";
    private static final CardStrings cardStrings;

    static 
    {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("Wish");
    }
}
