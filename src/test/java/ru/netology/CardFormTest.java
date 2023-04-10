package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardFormTest {
    @BeforeEach
    void setupTest(){
        open("http://localhost:9999");
    }
    @Test
    void shouldSuccessfulSendValidForm() {
        $("[data-test-id=name] input").setValue("Иванов Иван");
        $("[data-test-id=phone] input").setValue("+79287215679");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id ='order-success']").shouldHave(text(" Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}