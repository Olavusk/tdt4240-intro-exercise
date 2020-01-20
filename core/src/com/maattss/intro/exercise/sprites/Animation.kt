package com.maattss.intro.exercise.sprites

import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.utils.Array

class Animation(region: TextureRegion, frameCount: Int, cycleTime: Float) {
    private val frames: Array<TextureRegion> = Array()
    private val maxFrameTime: Float
    private val frameCount: Int
    private val frameWidth = region.regionWidth / frameCount
    private var currentFrameTime = 0f
    private var frame: Int = 0

    fun update(dt: Float) {
        currentFrameTime += dt
        if (currentFrameTime > maxFrameTime) {
            frame++
            currentFrameTime = 0f
        }
        if (frame >= frameCount) frame = 0
    }

    fun getFrame(): TextureRegion {
        return frames[frame]
    }

    init {
        for (i in 0 until frameCount) {
            frames.add(TextureRegion(region, i * frameWidth, 0,
                    frameWidth, region.regionHeight))
        }
        this.frameCount = frameCount
        maxFrameTime = cycleTime / frameCount
    }
}