package model.effects;

import exceptions.UnrecognizedEffectException;

public class Effect {
    private String name;
    private int duration;
    private EffectType type;

    public Effect(String name, int duration, EffectType type) {
        this.name = name;
        this.duration = duration;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public EffectType getType() {
        return type;
    }

    public static Effect fromName(String name, int duration) throws UnrecognizedEffectException {
        switch (name) {
            case Disarm.EFFECT_NAME:
                return new Disarm(duration);
            case Dodge.EFFECT_NAME:
                return new Dodge(duration);
            case Embrace.EFFECT_NAME:
                return new Embrace(duration);
            case PowerUp.EFFECT_NAME:
                return new PowerUp(duration);
            case Root.EFFECT_NAME:
                return new Root(duration);
            case Shield.EFFECT_NAME:
                return new Shield(duration);
            case Shock.EFFECT_NAME:
                return new Shock(duration);
            case Silence.EFFECT_NAME:
                return new Silence(duration);
            case SpeedUp.EFFECT_NAME:
                return new SpeedUp(duration);
            case Stun.EFFECT_NAME:
                return new Stun(duration);
            default:
                throw new UnrecognizedEffectException(name);
        }
    }
}