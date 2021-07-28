package com.blacklamp.incwadi.utils

import java.io.IOException

class ApiException(message: String) : IOException() {}
class NoInternetException(message: String) : IOException() {}