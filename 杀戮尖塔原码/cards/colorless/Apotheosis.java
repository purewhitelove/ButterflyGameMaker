// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Apotheosis.java

package com.megacrit.cardcrawl.cards.colorless;

import com.megacrit.cardcrawl.actions.unique.ApotheosisAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.LocalizedStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Apotheosis extends AbstractCard
{

    public Apotheosis()
    {
        super("Apotheosis", cardStrings.NAME, "colorless/skill/apotheosis", 2, cardStrings.DESCRIPTION, com.megacrit.cardcrawl.cards.AbstractCard.CardType.SKILL, com.megacrit.cardcrawl.cards.AbstractCard.CardColor.COLORLESS, com.megacrit.cardcrawl.cards.AbstractCard.CardRarity.RARE, com.megacrit.cardcrawl.cards.AbstractCard.CardTarget.NONE);
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        addToBot(new ApotheosisAction());
    }

    public void upgrade()
    {
        if(!upgraded)
        {
            upgradeName();
            upgradeBaseCost(1);
        }
    }

    public AbstractCard makeCopy()
    {
        return new Apotheosis();
    }

    public static final String ID = "Apotheosis";
    private static final CardStrings cardStrings;

    static 
    {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("Apotheosis");
    }
}
