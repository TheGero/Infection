public class HumanCreator {
    public IHuman createHuman(Map parentMap) {
        Human h = new Human(parentMap);
        return h;
    }

    public IHuman createDoctor(Map parentMap) {
        Doctor d = new Doctor(parentMap);
        return d;
    }

    public IHuman createInfected(Map parentMap, VirusData vData) {
        IHuman h = createHuman(parentMap);
        Virus v = new Virus(h, vData);
        h.infect(v);
        return h;
    }
}
