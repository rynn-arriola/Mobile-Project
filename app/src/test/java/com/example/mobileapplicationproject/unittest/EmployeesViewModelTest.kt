import android.content.res.Resources
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mobileapplicationproject.model.response.Employee
import com.example.mobileapplicationproject.model.response.Employees
import com.example.mobileapplicationproject.model.usecase.GetEmployeeUseCase
import com.example.mobileapplicationproject.util.State
import com.example.mobileapplicationproject.viewmodel.EmployeesViewModel
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class EmployeesViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: EmployeesViewModel
    private val dispatcher = TestCoroutineDispatcher()
    private val getEmployeeUseCase: GetEmployeeUseCase = mockk()
    private val resource: Resources = mockk()

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        dispatcher.cleanupTestCoroutines()
        Dispatchers.resetMain()
        unmockkAll()
    }

    @Test
    fun `when fetChData is called and use case returns success, then state is set to Success`() =
        runBlocking {

            val employees = getEmployees()
            coEvery { getEmployeeUseCase.getEmployees() } returns employees
            viewModel = EmployeesViewModel(getEmployeeUseCase, resource)
            val expectedState = State.Success(employees)
            val actualState = viewModel.state.value

            assertEquals(expectedState, actualState)
        }

    @Test
    fun `when fetChData is called and use case throws exception, then state is set to Error`() =
        runBlocking {

            val exception = RuntimeException("network error")
            coEvery { getEmployeeUseCase.getEmployees() } throws exception
            viewModel = EmployeesViewModel(getEmployeeUseCase, resource)
            val expectedState = State.Error("network error")
            val actualState = viewModel.state.value

            assertEquals(expectedState, actualState)
        }

    @Test
    fun `sort employee alphabetical`() {
        val unsorted = getEmployeesUnsorted()
        viewModel = EmployeesViewModel(getEmployeeUseCase, resource)
        val sorted = viewModel.sortEmployeesAlphabetical(unsorted)


        val expected = getEmployeesSorted()
        assertEquals(expected, sorted)
    }

    private fun getEmployees(): Employees {
        return Employees(
            listOf(
                Employee(
                    "Biography 1",
                    "email1@example.com",
                    "Employee Type 1",
                    "Anna Belle",
                    "1234567890",
                    "photo_url_large_1",
                    "photo_url_small_1",
                    "Team 1",
                    "uuid1"
                ),
                Employee(
                    "Biography 2",
                    "email2@example.com",
                    "Employee Type 2",
                    "Lebron James",
                    "1234567891",
                    "photo_url_large_2",
                    "photo_url_small_2",
                    "Team 2",
                    "uuid2"
                ),
                Employee(
                    "Biography 3",
                    "email3@example.com",
                    "Employee Type 3",
                    "John Doe",
                    "1234567892",
                    "photo_url_large_3",
                    "photo_url_small_3",
                    "Team 3",
                    "uuid3"
                )
            )
        )
    }

    private fun getEmployeesUnsorted(): List<Employee> {
        return listOf(
            Employee(
                "Biography 1",
                "email1@example.com",
                "Employee Type 1",
                "Anna Belle",
                "1234567890",
                "photo_url_large_1",
                "photo_url_small_1",
                "Team 1",
                "uuid1"
            ),
            Employee(
                "Biography 2",
                "email2@example.com",
                "Employee Type 2",
                "Lebron James",
                "1234567891",
                "photo_url_large_2",
                "photo_url_small_2",
                "Team 2",
                "uuid2"
            ),
            Employee(
                "Biography 3",
                "email3@example.com",
                "Employee Type 3",
                "John Doe",
                "1234567892",
                "photo_url_large_3",
                "photo_url_small_3",
                "Team 3",
                "uuid3"
            )
        )
    }

    private fun getEmployeesSorted(): List<Employee> {
        return listOf(
            Employee(
                "Biography 1",
                "email1@example.com",
                "Employee Type 1",
                "Anna Belle",
                "1234567890",
                "photo_url_large_1",
                "photo_url_small_1",
                "Team 1",
                "uuid1"
            ),
            Employee(
                "Biography 3",
                "email3@example.com",
                "Employee Type 3",
                "John Doe",
                "1234567892",
                "photo_url_large_3",
                "photo_url_small_3",
                "Team 3",
                "uuid3"
            ),
            Employee(
                "Biography 2",
                "email2@example.com",
                "Employee Type 2",
                "Lebron James",
                "1234567891",
                "photo_url_large_2",
                "photo_url_small_2",
                "Team 2",
                "uuid2"
            )
        )
    }

}