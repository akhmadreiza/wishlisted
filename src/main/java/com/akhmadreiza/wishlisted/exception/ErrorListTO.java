package com.akhmadreiza.wishlisted.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ErrorListTO {

    @JsonProperty(value = "errors")
    private List<ErrorTO> errorTO;

    public List<ErrorTO> getErrorTO() {
        return errorTO;
    }

    public void setErrorTO(List<ErrorTO> errorTO) {
        this.errorTO = errorTO;
    }
}
