package harvest.save;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author golivares
 */
public class SaveJson {

    private String id;
    private String date_harvested;
    private String source;
    private String language;
    private String title;
    private String text;
    private String publication_date;
    private String category;
    private String Keywords;
    private String creator;

    private String comercialname;
    private String totalsanctions;
    private String totalamount;
    private JSONArray records;

    private String address;
    private String type;
    private String program;
    private String list;

    private String resolutiondate;
    private String noresolution;
    private String sumilla;
    private String monto;
    private String crecurso;
    private String nresolutiva;
    private String resolutiva;

    private String entities;
    private String modality;

    private String company;
    private String name;
    private String subsector;
    private String penalty_fee;
    private String datesanction;
    private String sanction;

    public String getSanction() {
        return sanction;
    }

    public void setSanction(String sanction) {
        this.sanction = sanction;
    }

    public String getSubsector() {
        return subsector;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setSubsector(String subsector) {
        this.subsector = subsector;
    }

    public String getPenalty_fee() {
        return penalty_fee;
    }

    public void setPenalty_fee(String penalty_fee) {
        this.penalty_fee = penalty_fee;
    }

    public String getDatesanction() {
        return datesanction;
    }

    public void setDatesanction(String datesanction) {
        this.datesanction = datesanction;
    }

    public String getEntities() {
        return entities;
    }

    public void setEntities(String entities) {
        this.entities = entities;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public JSONArray getRecords() {
        return records;
    }

    public void setRecords(JSONArray records) {
        this.records = records;
    }

    public String getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

    public String getTotalsanctions() {
        return totalsanctions;
    }

    public void setTotalsanctions(String totalsanctions) {
        this.totalsanctions = totalsanctions;
    }

    public String getComercialname() {
        return comercialname;
    }

    public void setComercialname(String comercialname) {
        this.comercialname = comercialname;
    }

    public String getResolutiondate() {
        return resolutiondate;
    }

    public void setResolutiondate(String resolutiondate) {
        this.resolutiondate = resolutiondate;
    }

    public String getNoresolution() {
        return noresolution;
    }

    public void setNoresolution(String noresolution) {
        this.noresolution = noresolution;
    }

    public String getSumilla() {
        return sumilla;
    }

    public void setSumilla(String sumilla) {
        this.sumilla = sumilla;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getCrecurso() {
        return crecurso;
    }

    public void setCrecurso(String crecurso) {
        this.crecurso = crecurso;
    }

    public String getNresolutiva() {
        return nresolutiva;
    }

    public void setNresolutiva(String nresolutiva) {
        this.nresolutiva = nresolutiva;
    }

    public String getResolutiva() {
        return resolutiva;
    }

    public void setResolutiva(String resolutiva) {
        this.resolutiva = resolutiva;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String Program) {
        this.program = Program;
    }

    public String getList() {
        return list;
    }

    public void setList(String List) {
        this.list = List;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getKeywords() {
        return Keywords;
    }

    public void setKeywords(String Keywords) {
        this.Keywords = Keywords;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate_harvested() {
        return date_harvested;
    }

    public void setDate_harvested(String date_harvested) {
        this.date_harvested = date_harvested;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public JSONObject toJSON(String type) {
        JSONObject root = new JSONObject();
        JSONObject metadata = new JSONObject();

        if (this.id != null) {
            metadata.put("id", this.id);
        }
        if (this.date_harvested != null) {
            metadata.put("date_harvest", this.date_harvested);
        }
        if (this.source != null) {
            metadata.put("source", this.source);
        }
        if (this.language != null) {
            metadata.put("language", this.language);
        }
        if (this.title != null) {
            metadata.put("title", this.title);
        }
        if (this.text != null) {
            metadata.put("text", this.text);
        }
        if (this.publication_date != null) {
            metadata.put("publication_date", this.publication_date);
        }
        if (this.category != null) {
            metadata.put("category", this.category);
        }

        if (this.Keywords != null) {
            metadata.put("keywords", this.Keywords);
        }

        if (this.creator != null) {
            metadata.put("creator", this.creator);
        }

        if (this.name != null) {
            metadata.put("name", this.name);
        }

        if (this.address != null) {
            metadata.put("address", this.address);
        }

        if (this.type != null) {
            metadata.put("type", this.type);
        }

        if (this.program != null) {
            metadata.put("program", this.program);
        }

        if (this.list != null) {
            metadata.put("list", this.list);
        }

        if (this.resolutiondate != null) {
            metadata.put("resolution date", this.resolutiondate);
        }

        if (this.resolutiondate != null) {
            metadata.put("resolution date", this.resolutiondate);
        }

        if (this.noresolution != null) {
            metadata.put("resolution number", this.noresolution);
        }

        if (this.noresolution != null) {
            metadata.put("resolution number", this.noresolution);
        }

        if (this.sumilla != null) {
            metadata.put("sumilla", this.sumilla);
        }

        if (this.monto != null) {
            metadata.put("amount", this.monto);
        }

        if (this.crecurso != null) {
            metadata.put("with recourse", this.crecurso);
        }

        if (this.nresolutiva != null) {
            metadata.put("final resolution number", this.nresolutiva);
        }

        if (this.resolutiva != null) {
            metadata.put("date of operative response", this.resolutiva);
        }
        if (this.comercialname != null) {
            metadata.put("comercial name", this.comercialname);
        }

        if (this.totalsanctions != null) {
            metadata.put("total sanctions", this.totalsanctions);
        }

        if (this.totalamount != null) {
            metadata.put("total amount", this.totalamount);
        }
        if (this.records != null) {
            metadata.put("records", this.records);
        }

        if (this.modality != null) {
            metadata.put("modality", this.modality);
        }

        if (this.entities != null) {
            metadata.put("entities", this.entities);
        }

        if (this.subsector != null) {
            metadata.put("subsector", this.subsector);
        }

        if (this.penalty_fee != null) {
            metadata.put("penalty_fee", this.penalty_fee);
        }

        if (this.datesanction != null) {
            metadata.put("datesanction", this.datesanction);
        }

        if (this.sanction != null) {
            metadata.put("sanction", this.sanction);
        }

        if (this.company != null) {
            metadata.put("company", this.company);
        }

        root.put(type, metadata);
        return root;
    }

}
