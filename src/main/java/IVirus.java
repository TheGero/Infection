public interface IVirus {
    void update();

    int getSymptomsVisibility();

    VirusData getVirusData();

    boolean hasMutatedLastStep();
}
