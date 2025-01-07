using AddressBook.Models;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using System.Text;

namespace AddressBook.Controllers
{
    public class CountryController : Controller
    {
        private readonly IConfiguration _configuration;
        private readonly HttpClient _httpClient;

        public CountryController(IConfiguration configuration)
        {
            _configuration = configuration;
            _httpClient = new HttpClient 
            {
                 BaseAddress = new System.Uri(_configuration["WebApiBaseUrl"])
            };
        }
        public IActionResult Index()
        {
            return View();
        }
        [HttpGet]
        public async Task<IActionResult> CountryList()
        {
            var response = await _httpClient.GetAsync("api/Country");
            if (response.IsSuccessStatusCode)
            {
                var data = await response.Content.ReadAsStringAsync();
                var countries = JsonConvert.DeserializeObject<List<CountryModel>>(data);    
                return View(countries);
            }
            return View(new List<CountryModel>());

        }

        public async Task<IActionResult> CountryAddEdit(int? CountryID)
        {
            if (CountryID.HasValue)
            {
                var response = await _httpClient.GetAsync($"api/Country/{CountryID}");
                if (response.IsSuccessStatusCode)
                {
                    var data = await response.Content.ReadAsStringAsync();
                    var country = JsonConvert.DeserializeObject<CountryModel>(data);
                    return View(country);
                }

            }
            return View(new CountryModel());
        }

        [HttpPost]
        public async Task<IActionResult> CountrySave(CountryModel cm)
        {
            if(ModelState.IsValid)
            {
                var json = JsonConvert.SerializeObject(cm);
                var content = new StringContent(json,Encoding.UTF8,"application/json");
                HttpResponseMessage response;

                if(cm.CountryID == null || cm.CountryID == 0)
                {
                    response = await _httpClient.PostAsync("api/Country",content);
                }
                else 
                {
                    response = await _httpClient.PutAsync($"api/Country/{cm.CountryID}", content);
                }

                if (response.IsSuccessStatusCode)
                {
                    return RedirectToAction("CountryList");
                }
            }
                return View("CountryAddEdit",cm);
        }

        public async Task<IActionResult> DeleteCountry(int CountryID)
        {
            var response = await _httpClient.DeleteAsync($"api/Country/{CountryID}");
            return RedirectToAction("CountryList");
        }


    }
}
