package unisa.dse.a2.students;

public class UntradedCompanyException
{
	public UntradedCompanyException(String companyCode)
	{
		System.out.println(companyCode + " is not a listed company on this exchange");
	}
}
