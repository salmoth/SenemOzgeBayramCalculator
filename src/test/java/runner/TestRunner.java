package runner;

import testCases.CalculatorTestCases;

import java.util.ArrayList;
import java.util.List;

        public class TestRunner {

            public static void main(String[] args) {
                System.out.println("Test çalıştırıcı başlatılıyor...\n");
                List<String> failedTests = new ArrayList<>();

                try {
                    CalculatorTestCases testInstance = new CalculatorTestCases();

                    System.out.println("Tarayıcı Açılıyor ve Login İşlemi Yapılıyor.\n");
                    testInstance.setup();
                    System.out.println("Tarayıcı Açıldı ve Login İşlemi Yapıldı.\n");

                    System.out.println("----------------------------");

                    try {
                        System.out.println("Senaryo 1: Yatırım Hesaplaması Testi Çalıştırılıyor.\n");
                        testInstance.setup();
                        testInstance.testInvestmentCalculation();
                        System.out.println("TEST BAŞARILI: Senaryo 1: Yatırım Hesaplaması Testi.\n");
                    } catch (Exception e) {
                        System.err.println("TEST BAŞARISIZ: Senaryo 1: Yatırım Hesaplaması Testi.");
                        failedTests.add("Senaryo 1: Yatırım Hesaplaması Testi");
                    }

                    try {
                        System.out.println("Senaryo 2: Aylık Bütçe Hesaplaması - Veri 1 Çalıştırılıyor.\n");
                        testInstance.setup();
                        testInstance.testMonthlyBudgetCalculationCase1();
                        System.out.println("TEST BAŞARILI: Senaryo 2: Aylık Bütçe Hesaplaması - Veri 1\n");
                    } catch (Exception e) {
                        System.err.println("TEST BAŞARISIZ: Senaryo 2: Aylık Bütçe Hesaplaması - Veri 1.");
                        failedTests.add("Senaryo 2: Aylık Bütçe Hesaplaması - Veri 1");
                    }
                    try {
                        System.out.println("Senaryo 2: Aylık Bütçe Hesaplaması - Veri 1 Çalıştırılıyor.\n");
                        testInstance.setup();
                        testInstance.testMonthlyBudgetCalculationCase2();
                        System.out.println("TEST BAŞARILI: Senaryo 2: Aylık Bütçe Hesaplaması - Veri 2\n");
                    } catch (Exception e) {
                        System.err.println("TEST BAŞARISIZ: Senaryo 2: Aylık Bütçe Hesaplaması - Veri 2.");
                        failedTests.add("Senaryo 2: Aylık Bütçe Hesaplaması - Veri 2");
                    }
                    try {
                        System.out.println("Senaryo 2: Aylık Bütçe Hesaplaması - Veri 3 Çalıştırılıyor.\n");
                        testInstance.setup();
                        testInstance.testMonthlyBudgetCalculationCase3();
                        System.out.println("TEST BAŞARILI: Senaryo 2: Aylık Bütçe Hesaplaması - Veri 3\n");
                    } catch (Exception e) {
                        System.err.println("TEST BAŞARISIZ: Senaryo 2: Aylık Bütçe Hesaplaması - Veri 3.");
                        failedTests.add("Senaryo 2: Aylık Bütçe Hesaplaması - Veri 3");
                    }
                    try {
                        System.out.println("Senaryo 2: Aylık Bütçe Hesaplaması - Veri 4 Çalıştırılıyor.\n");
                        testInstance.setup();
                        testInstance.testMonthlyBudgetCalculationCase4();
                        System.out.println("TEST BAŞARILI: Senaryo 2: Aylık Bütçe Hesaplaması - Veri 4\n");
                    } catch (Exception e) {
                        System.err.println("TEST BAŞARISIZ: Senaryo 2: Aylık Bütçe Hesaplaması - Veri 4.");
                        failedTests.add("Senaryo 2: Aylık Bütçe Hesaplaması - Veri 4");
                    }
                    try {
                        System.out.println("Senaryo 2: Aylık Bütçe Hesaplaması - Veri 5 Çalıştırılıyor.\n");
                        testInstance.setup();
                        testInstance.testMonthlyBudgetCalculationCase5();
                        System.out.println("TEST BAŞARILI: Senaryo 2: Aylık Bütçe Hesaplaması - Veri 5\n");
                    } catch (Exception e) {
                        System.err.println("TEST BAŞARISIZ: Senaryo 2: Aylık Bütçe Hesaplaması - Veri 5.");
                        failedTests.add("Senaryo 2: Aylık Bütçe Hesaplaması - Veri 5");
                    }
                    try {
                        System.out.println("Senaryo 2: Aylık Bütçe Hesaplaması - Veri 6 Çalıştırılıyor.\n");
                        testInstance.setup();
                        testInstance.testMonthlyBudgetCalculationCase6();
                        System.out.println("TEST BAŞARILI: Senaryo 2: Aylık Bütçe Hesaplaması - Veri 6\n");
                    } catch (Exception e) {
                        System.err.println("TEST BAŞARISIZ: Senaryo 2: Aylık Bütçe Hesaplaması - Veri 6.");
                        failedTests.add("Senaryo 2: Aylık Bütçe Hesaplaması - Veri 6");
                    }

                    try {
                        System.out.println("Senaryo 4: Kısa Vadeli Yatırım Hesaplaması Çalıştırılıyor.\n");
                        testInstance.setup();
                        testInstance.testShortTermInvestment();
                        System.out.println("TEST BAŞARILI: Senaryo 4: Kısa Vadeli Yatırım Hesaplaması\n");
                    } catch (Exception e) {
                        System.err.println("TEST BAŞARISIZ: Senaryo 4: Kısa Vadeli Yatırım Hesaplaması.");
                        failedTests.add("Senaryo 4: Kısa Vadeli Yatırım Hesaplaması");
                    }

                    try {
                        System.out.println("Senaryo 5: Günlük Gider Takibi Çalıştırılıyor.\n");
                        testInstance.setup();
                        testInstance.testDailyExpenseTracking();
                        System.out.println("TEST BAŞARILI: Senaryo 5: Günlük Gider Takibi\n");
                    } catch (Exception e) {
                        System.err.println("TEST BAŞARISIZ: Senaryo 5: Günlük Gider Takibi.");
                        failedTests.add("Senaryo 5: Günlük Gider Takibi");
                    }

                    try {
                        System.out.println("Senaryo 6: Yıllık Yatırım Hesaplaması Çalıştırılıyor.\n");
                        testInstance.setup();
                        testInstance.testAnnualInvestmentCalculation();
                        System.out.println("TEST BAŞARILI: Senaryo 6: Yıllık Yatırım Hesaplaması\n");
                    } catch (Exception e) {
                        System.err.println("TEST BAŞARISIZ: Senaryo 6: Yıllık Yatırım Hesaplaması.");
                        failedTests.add("Senaryo 6: Yıllık Yatırım Hesaplaması");
                        testInstance.teardown();
                    }

                } catch (Exception e) {
                    System.err.println("Test ortamı hazırlanırken bir hata oluştu!");
                    e.printStackTrace();
                }
                System.out.println("----------------------------");
                System.out.println("Tüm testler tamamlandı.");

                if (failedTests.isEmpty()) {
                    System.out.println("Tüm testler başarılı!");
                } else {
                    System.out.println("Başarısız olan testler:");
                    for (String testName : failedTests) {
                        System.out.println("- " + testName);
                    }
                }
            }
        }

