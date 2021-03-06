package com.twitter.finagle.serverset2.client

import org.scalatest.FunSuite

class ZooKeeperClientTest extends FunSuite {
  test("ZooKeeperReader.patToPathAndPrefix") {
    import ZooKeeperReader.{patToPathAndPrefix => p}

    intercept[IllegalArgumentException] { p("") }
    intercept[IllegalArgumentException] { p("foo/bar") }

    assert(p("/") == (("/", "")))
    assert(p("/foo") == (("/", "foo")))
    assert(p("/foo/bar") == (("/foo", "bar")))
    assert(p("/foo/bar/") == (("/foo/bar", "")))
  }
}
