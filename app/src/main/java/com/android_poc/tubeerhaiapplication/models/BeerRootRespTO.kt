import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2020 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


public data class BeerRootRespTO(

	@SerializedName("id") val id: Int,
	@SerializedName("name") val name: String,
	@SerializedName("tagline") val tagline: String,
	@SerializedName("first_brewed") val first_brewed: String,
	@SerializedName("description") val description: String,
	@SerializedName("image_url") val image_url: String,
	@SerializedName("abv") val abv: Double,
	@SerializedName("ibu") val ibu: Double,
	@SerializedName("target_fg") val target_fg: Double,
	@SerializedName("target_og") val target_og: Double,
	@SerializedName("ebc") val ebc: Double,
	@SerializedName("srm") val srm: Double,
	@SerializedName("ph") val ph: Double,
	@SerializedName("attenuation_level") val attenuation_level: Double,
	@SerializedName("volume") val volume: Volume,
	@SerializedName("boil_volume") val boil_volume: Boil_volume,
	@SerializedName("method") val method: Method,
	@SerializedName("ingredients") val ingredients: Ingredients,
	@SerializedName("food_pairing") val food_pairing: List<String>,
	@SerializedName("brewers_tips") val brewers_tips: String,
	@SerializedName("contributed_by") val contributed_by: String
)