package RssReader.domain;

import RssReader.constant.ConvertTypeEnum;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static RssReader.constant.Constants.HTTPS_PREFIX;
import static RssReader.constant.Constants.HTTP_PREFIX;

/**
 * コマンドライン引数を保持するクラス
 */
@Data
public class Argument {

    private String input;

    private List<ConvertTypeEnum> convertTypeList;

    private String output;

    public boolean isInputRss() {
        return input.startsWith(HTTP_PREFIX) || input.startsWith(HTTPS_PREFIX);
    }

    public boolean isOutputFile() {
        return StringUtils.isNotEmpty(output);
    }
}
