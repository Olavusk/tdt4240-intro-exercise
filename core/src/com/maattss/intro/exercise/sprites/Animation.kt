package com.maattss.intro.exercise.sprites

import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.utils.Array

class Animation(region: TextureRegion, frameCount: Int, cycleTime: Float) {
    private val frames: Array<TextureRegion>
    private val maxFrameTime: Float
    private var currentFrameTime = 0f
    private val frameCount: Int
    private var frame: Int
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
        frames = Array()
        val frameWidth = region.regionWidth / frameCount
        for (i in 0 until frameCount) {
            frames.add(TextureRegion(region, i * frameWidth, 0, frameWidth, region.regionHeight))
        }
        this.frameCount = frameCount
        maxFrameTime = cycleTime / frameCount
        frame = 0
    }
}