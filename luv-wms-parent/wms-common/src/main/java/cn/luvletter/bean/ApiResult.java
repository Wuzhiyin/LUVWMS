package cn.luvletter.bean;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.io.Serializable;
import java.util.List;

/**
 * @author Zephyr Ji
 * @ Description: 返回前端实体
 * @ Date 2018/2/9
 */
public class ApiResult implements Serializable{

    private static final long serialVersionUID = 1837004257486125428L;
    /**
     * 返回状态，默认成功success，失败false
     */
    private String status = "success";
    /**
     * 返回消息
     */
    private String message;
    /**
     * 数据
     */
    private Object data;

    private long total;

    public ApiResult() {}
    public ApiResult(String message){
        this.message = message;
    }
    public ApiResult(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public ApiResult isFalse(){
        this.status="false";
        return this;
    }

    public void setMessage(List<FieldError> fieldErrorList){
            StringBuilder sb = new StringBuilder();
            for(FieldError fieldError : fieldErrorList){
                sb.append(fieldError.getDefaultMessage());
            }
            this.setMessage(sb.toString());
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ApiResult{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", total=" + total +
                '}';
    }
}
