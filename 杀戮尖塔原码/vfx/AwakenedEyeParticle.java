// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AwakenedEyeParticle.java

package com.megacrit.cardcrawl.vfx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.ImageMaster;

// Referenced classes of package com.megacrit.cardcrawl.vfx:
//            AbstractGameEffect

public class AwakenedEyeParticle extends AbstractGameEffect
{

    public AwakenedEyeParticle(float x, float y)
    {
        duration = MathUtils.random(0.5F, 1.0F);
        startingDuration = duration;
        img = ImageMaster.ROOM_SHINE_2;
        this.x = x - (float)(img.packedWidth / 2);
        this.y = y - (float)(img.packedHeight / 2);
        scale = Settings.scale * MathUtils.random(0.5F, 1.0F);
        rotation = 0.0F;
        color = new Color(MathUtils.random(0.2F, 0.4F), MathUtils.random(0.8F, 1.0F), MathUtils.random(0.8F, 1.0F), 0.01F);
    }

    public void update()
    {
        duration -= Gdx.graphics.getDeltaTime();
        if(duration < 0.0F)
            isDone = true;
        color.a = Interpolation.fade.apply(0.0F, 0.5F, duration / startingDuration);
    }

    public void render(SpriteBatch sb)
    {
        sb.setBlendFunction(770, 1);
        sb.setColor(color);
        sb.draw(img, x, y, (float)img.packedWidth / 2.0F, (float)img.packedHeight / 2.0F, img.packedWidth, img.packedHeight, scale * MathUtils.random(6F, 12F), scale * MathUtils.random(0.7F, 0.8F), rotation + MathUtils.random(-1F, 1.0F));
        sb.draw(img, x, y, (float)img.packedWidth / 2.0F, (float)img.packedHeight / 2.0F, img.packedWidth, img.packedHeight, scale * MathUtils.random(0.2F, 0.5F), scale * MathUtils.random(2.0F, 3F), rotation + MathUtils.random(-1F, 1.0F));
        sb.setBlendFunction(770, 771);
    }

    public void dispose()
    {
    }

    private float x;
    private float y;
    private com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion img;
}
