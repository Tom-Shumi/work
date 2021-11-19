/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package RssReader;

import RssReader.domain.Argument;
import RssReader.domain.Article;
import RssReader.service.convert.ConvertService;
import RssReader.service.input.InputService;
import RssReader.service.output.OutputService;
import RssReader.util.ConvertArgumentUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static RssReader.constant.ErrorMessage.ERROR_OCCURRED;
import static RssReader.constant.Message.SUCCESS;

/**
 * コントローラークラス
 */
public class App {

    /**
     * mainメソッド
     * @param args NotNull コマンドライン引数
     */
    public static void main(String[] args) {

        try {
            Argument argument = ConvertArgumentUtils.convertArgument(args);

            List<Article> articleList = InputService.input(argument);

            articleList = ConvertService.convert(articleList, argument);

            OutputService.output(articleList, argument);

            System.out.println(SUCCESS);

        } catch (Exception e) {
            printErrorMessage(e);
        }
    }

    private static void printErrorMessage(Exception e) {
        System.out.println(ERROR_OCCURRED);
        if (StringUtils.isNotEmpty(e.getMessage())) {
            System.out.println(e.getMessage());
        } else {
            e.printStackTrace();
        }
    }
}
