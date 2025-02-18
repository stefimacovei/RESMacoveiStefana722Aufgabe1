package Actions;

import java.time.LocalDate;
import java.util.Objects;

import static java.lang.Double.parseDouble;

public class Happened {
    private int id;
    private String characterName;
    private Stufe stufe;
    String beschreibung;
    private LocalDate datum;
    private double kraftpunkte;

    public Happened(int id, String characterName, String stufe, String beschreibung, String datum, String kraftpunkte) {
        this.id = id;
        this.characterName = characterName;
        for(Stufe s: Stufe.values()) {
            if(stufe.equals(s.toString())) {this.stufe = s;}
        }
        //
        this.beschreibung = beschreibung;

        String dateString = datum;

        this.datum= LocalDate.parse(dateString);
        this.kraftpunkte = parseDouble(kraftpunkte);
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Stufe getStufe() {
        return stufe;
    }

    public void setStufe(Stufe stufe) {
        this.stufe = stufe;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public double getKraftpunkte() {
        return kraftpunkte;
    }

    public void setKraftpunkte(double kraftpunkte) {
        this.kraftpunkte = kraftpunkte;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Happened happened = (Happened) o;
        return id == happened.id && Double.compare(kraftpunkte, happened.kraftpunkte) == 0 && Objects.equals(characterName, happened.characterName) && stufe == happened.stufe && Objects.equals(beschreibung, happened.beschreibung) && Objects.equals(datum, happened.datum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, characterName, stufe, beschreibung, datum, kraftpunkte);
    }

    @Override
    public String toString() {
        return "Happened{" +
                "id=" + id +
                ", characterName='" + characterName + '\'' +
                ", stufe=" + stufe +
                ", beschreibung='" + beschreibung + '\'' +
                ", datum=" + datum +
                ", kraftpunkte=" + kraftpunkte +
                '}';
    }
}
