package api;

import java.util.List;

public class ApiWithPojo {
    private boolean success;
    private List<Data> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public static class Data {
        private String CityID;

        public String getCityID() {
            return CityID;
        }

        public void setCityID(String cityID) {
            CityID = cityID;
        }
    }
}