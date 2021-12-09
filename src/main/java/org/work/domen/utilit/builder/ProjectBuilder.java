package org.work.domen.utilit.builder;

import org.work.domen.entity.Project;
import org.work.domen.entity.ProjectMarkStatus;
import org.work.domen.entity.Segment;

public interface ProjectBuilder {

    ProjectBuilder withSegment(Segment segment);

    ProjectBuilder withName(String name);

    ProjectBuilder withHead(String country);

    ProjectBuilder withHumanAmount(double succor);

    ProjectBuilder withAverageSalary(double incomeTax);

    ProjectBuilder withProfit(double financialIncome);

    ProjectBuilder withTerm(double depreciation);

    ProjectBuilder withProfitability(double ebitda);

    ProjectBuilder withProjectStatus(ProjectMarkStatus status);

    Project build();
}
