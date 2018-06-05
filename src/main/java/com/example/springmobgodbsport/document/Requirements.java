package com.example.springmobgodbsport.document;

public class Requirements {
    private boolean trainings;
    private boolean sauna;
    private boolean gym;
    private Integer numberOfTrainingsSession;

    public Requirements(boolean trainings, boolean sauna, boolean gym, Integer numberOfTrainingsSession) {
        this.trainings = trainings;
        this.sauna = sauna;
        this.gym = gym;
        this.numberOfTrainingsSession = numberOfTrainingsSession;
    }

    public boolean isTrainings() {
        return trainings;
    }

    public void setTrainings(boolean trainings) {
        this.trainings = trainings;
    }

    public boolean isSauna() {
        return sauna;
    }

    public void setSauna(boolean sauna) {
        this.sauna = sauna;
    }

    public boolean isGym() {
        return gym;
    }

    public void setGym(boolean gym) {
        this.gym = gym;
    }

    public Integer getNumberOfTrainingsSession() {
        return numberOfTrainingsSession;
    }

    public void setNumberOfTrainingsSession(Integer numberOfTrainingsSession) {
        this.numberOfTrainingsSession = numberOfTrainingsSession;
    }
}